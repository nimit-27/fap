# Legacy Payroll Application – Architecture & Migration Analysis (Partial, Evidence-Based)

## Scope and confidence
This pass prioritizes high-value entry points and user-triggered flows:
- `web.xml`, `struts-config.xml`, WebLogic/EJB descriptors
- Common JSP/action/DAO flows: Login, Change Password, Problem Report, Main Page menu dispatch
- One HRMS maintenance flow: Leave Master (query/insert/edit/reset/retrieve)
- Stored procedure dependency sampling from Java call sites

Confidence tags:
- **Confirmed from code/config**: direct evidence in inspected files.
- **Strongly inferred**: highly likely from naming + surrounding framework conventions.
- **Unresolved**: missing linkage in inspected set.

---

## 1) Executive summary

### What this app appears to do
- Enterprise payroll + HRMS system with module-based navigation, implemented as a classic Struts 1 monolith with JSP views and Java action/DAO layers.
- Access control and dynamic menu construction are user/location-driven, likely based on DB tables and user role mappings.
- Heavy Oracle dependency with both SQL and PL/SQL packages/procedures.

### High-level architecture
- Browser -> JSP (Struts tags + inline JS) -> `*.do` Struts actions -> business delegates/services -> DAO/DB utilities -> Oracle SQL/PLSQL.
- Session-centric UI state (`USERINFO`, password age/status, dynamic menu in session).
- EJB façade tier present and wired through deployment descriptors.

### Most important legacy technologies used
- JSP + Struts taglibs (`struts-html`, `struts-logic`, `struts-bean`).
- Struts 1 Action/ActionForm/action-mappings.
- EJB 2.x style remote homes/remotes + WebLogic JNDI bindings.
- Direct SQL + callable procedure integration via utility wrappers.
- WebLogic deployment descriptors and app-server-specific behavior.

### Biggest migration blockers
- Very large Struts mapping surface (~10k+ line config) with many action endpoints.
- Mixed logic placement (JSP JavaScript, action classes, DAO SQL text, PL/SQL packages).
- Session-bound navigation model and dynamic menu generation tightly coupled to server-side state.
- Legacy crypto/session patterns (MD5 password hashing in app layer, custom cookie handling).

### Security-sensitive areas
- Authentication + password flow (login attempts, password change, password age checks).
- Host header allowlist and cookie/header manipulation in filter.
- SQL construction by string concatenation in some DAO methods.
- Hardcoded JNDI credentials in one context provider.

### WebLogic dependencies found
- `weblogic.xml` context root + JSP debug flag.
- `weblogic-ejb-jar.xml` bean-to-JNDI mappings and call-by-reference flags.
- `ejb-jar.xml` EJB 2.1 remote home/remote beans and container transactions.

### Coverage summary
- **Fully analyzed (for selected flows):** Login, Change Password, Problem Report, MainPage menu/logout dispatch, LeaveMaster UI-to-action-to-DAO.
- **Partially analyzed:** stored procedure ecosystem (sampled, not exhaustively traced to UI for all modules).
- **Unresolved:** Full Payroll module end-to-end traces (many mappings not yet expanded), full authz role model derivation, datasource runtime/JNDI inventory from server config.

---

## 2) Technology primer for modern developers

- **JSP -> React component/server template analog**
  - JSP mixes HTML + server tags + scriptlets; rendered server-side per request.
  - Modern analog: React for client UI, plus REST backend.

- **Struts Action/ActionForm/mappings -> Spring MVC controller + DTOs**
  - Struts mapping binds URL path to `Action` class and form bean.
  - Modern analog: `@RestController` endpoint + request DTO + validation annotations.

- **EJB (remote/home interfaces) -> Spring services + module boundaries**
  - EJB descriptors define session beans and container-managed transactions.
  - Modern analog: Spring `@Service`, `@Transactional`, and dependency injection.

- **JNDI lookups -> externalized service discovery/config**
  - Legacy `ServiceLocator` does JNDI lookups for EJB/datasource handles.
  - Modern analog: Spring Boot config + connection pools + DI-managed beans.

- **Stored procedures -> DB-resident domain services**
  - PL/SQL handles complex payroll rules and batch operations.
  - Modern analog: keep critical data-heavy logic in DB initially; migrate business rules gradually to Java services when testable.

- **WebLogic deployment/runtime -> container + external config**
  - WebLogic descriptors configure context-root, EJB JNDI names, and runtime options.
  - Modern analog: Docker/Kubernetes + Spring externalized properties + managed identity/secrets.

---

## 3) Application structure (observed)

### Entry points
- Struts ActionServlet mapped to `*.do` and config `/WEB-INF/struts-config.xml`.
- Welcome file: `index.jsp`.

### UI layer
- JSPs under `public_html/COMMON/JSP`, `public_html/HRMS/JSP`, `public_html/Payroll/JSP/...`.
- Heavy inline JavaScript handling submit mode/action routing.

### Controller/action layer
- Struts action classes in `src/FCIPAY/.../WEBTIER/Action`.
- Key actions inspected: `LoginAction`, `MainPageAction`, `ChangePwdAction`, `ProblemReportAction`, `LeaveMastAction`.

### Business/service layer
- Business delegates in `.../BUSINESSTIER/BusinessDelegates`.
- EJB façade layer declared in `ejb-jar.xml` and WebLogic bindings.

### Data/procedure layer
- DAOs in `.../DATAACCESSTIER/DAO`.
- SQL constants in `.../DATAACCESSTIER/SQLQueries`.
- DB utility classes support SQL + callable procedures.

### Config and control files
- `web.xml`: servlet/filter/session/taglibs/ejb-ref wiring.
- `struts-config.xml`: form-beans/global forwards/action mappings.
- `weblogic.xml`, `weblogic-ejb-jar.xml`, `ejb-jar.xml`: deployment/runtime and EJB wiring.

---

## 4) UI action inventory (high-value subset)

### A. Login submit
- Confidence: **Confirmed from code/config**
- JSP/page: `COMMON/JSP/Login.jsp`
- UI element: `Login` submit
- Event: form submit + password `onblur` pre-submit
- JS: `lfnGetLocDtls`, `lfnOnSubmit`
- Form: `frmLogin`, action `/Login`, method `post`
- Struts mapping: `/Login` -> `LoginAction`
- Action handling:
  - `hdnAction=GetLocDetails`: load location list.
  - `hdnAction=Login`: validate user/password/location and set session `USERINFO`.
- Service/delegate: `LoginBD`
- DAO/JDBC: `LoginDAO.getLocationCodes`, `getEmpDetails`
- Stored proc/package:
  - SQL function call via query `pkg_pay_fixed_misc_param.Get_Allow_Value('MAX_LOGIN_ATTEMPT',null)`
- Response/forward: success returns Login.jsp; on successful credentials forwards MainPage.
- Purpose: user authentication + location scoping.
- Migration notes: split into API endpoints: `/auth/login`, `/auth/locations`; replace MD5 and server-rendered flow.

### B. Change Password (Home button)
- Confidence: **Confirmed from code/config**
- JSP: `COMMON/JSP/ChangePwd.jsp`
- UI: `Home` button
- Event: `onclick` -> `setHidden(this.value)` sets `hdnAction=Home`
- Mapping: `/ChangePwd` -> `ChangePwdAction`
- Action method: if `Home`, forward MainPage.
- DB/procedure: none for this branch.
- Purpose: navigation back to main dashboard.

### C. Change Password (Change Password button)
- Confidence: **Confirmed from code/config**
- UI: `Change Password` button
- JS: `lfnSave` validates old/new mismatch and confirm match; submits `hdnAction`.
- Mapping/action: `/ChangePwd` -> `ChangePwdAction` branch `hdnAction="Change Password"`
- Service: direct DAO invocation (`ChangePwdDAO`) from action.
- DAO/JDBC: `executeUpsert` of `PasswordQueries.sql_ChangePwd`.
- Stored proc/package: none (direct update query).
- Response: forward `success` back to same JSP with message.
- Purpose: authenticated password update.
- Migration notes: enforce password policy centrally on backend + BCrypt/Argon2.

### D. Problem Reporting (Save)
- Confidence: **Confirmed from code/config**
- JSP: `COMMON/JSP/ProblemReport.jsp`
- UI: `Save`
- JS: `setHidden('Save')`
- Mapping: `/Problem` -> `ProblemReportAction`
- Action method: build VO with screen/problem/cause + session user/location.
- DAO/JDBC: `ProblemReportDAO.saveDtls`
- Stored proc/package:
  - SQL uses `get_id(?,'sysadmin_problem_report')` in insert value generation (DB function).
- Response: success message on same page.
- Purpose: capture user-reported defects/issues.

### E. Problem Reporting (Reset)
- Confidence: **Confirmed from code/config**
- UI: `Reset`
- JS: `setHidden('Reset')`
- Action branch: clears form fields in `ResetForm`.
- DB: none.

### F. Main page module buttons / logout / change password
- Confidence: **Confirmed from code/config**
- JSP: `COMMON/JSP/MainPage.jsp`
- UI: `Logout`, `Change Password`, dynamically iterated module buttons
- Event: `setHidden(value)` on button click, submits `hdnAction`
- Mapping: `/MainPage` -> `MainPageAction`
- Action branches:
  - `OnLoad`: load module list from DAO.
  - `Logout`: invalidate session -> Login page.
  - `Change Password`: forward to change password page.
  - Else module name: resolve dynamic menu list and set employee type flag.
- DB/procedure: in DAO layer (partially inspected), dynamic menu appears DB-driven.
- Response: forwards to Main/Home page depending on action.

### G. Leave Master (Query/Insert/Edit/Reset/Retrieve)
- Confidence: **Confirmed from code/config**
- JSP: `HRMS/JSP/frmLeaveMaster.jsp`
- UI: Query/Insert/Edit/Reset buttons + leave select dropdown change event
- JS: `setHidden`, `onInsert`, `onEdit`, `showMode`
- Form: `frmLeaveMaster`, action `/LeaveMastAction`
- Mapping: `/LeaveMastAction` -> `LeaveMastAction`
- Action branches: `Insert`, `Edit`, `Query`, `Reset`, `Retrieve` based on `sAction`
- Business delegate: `LeaveMastBD`
- DAO/JDBC: `LeaveMastDAO`
  - Insert/update done with dynamically concatenated SQL strings.
  - Query operations fetch leave master records.
- Stored proc/package: none in inspected LeaveMastDAO path (table SQL used).
- Response: same JSP with messages.
- Migration notes: highest-priority SQL injection hardening before migration.

---

## 5) End-to-end flow traces (major journeys)

### Flow 1: Login with location resolution
- Confidence: **Confirmed from code/config**
1. User enters userId/password in `Login.jsp`; `txtPwd` blur triggers `lfnGetLocDtls()` and submits with `hdnAction=GetLocDetails`.
2. Struts `/Login.do` routes to `LoginAction.execute`.
3. `LoginAction` calls `LoginBD.getLocationCodes(user, md5(password))`.
4. `LoginDAO.getLocationCodes` checks lock count (`PSSWD_CHANGED`) and compares against `MAX_LOGIN_ATTEMPT` from DB function package.
5. If valid, location list is loaded; if no rows, login attempt incremented and invalid user error.
6. On final `Login` submit, action calls `LoginBD.getEmpDetails(...)`, sets `USERINFO` and `psswrdStts` session attributes, forwards MainPage.
7. MainPage JSP uses `psswrdStts` to force “Change Password” if age >= 90 days.

Data passed:
- userId, password (MD5), location code.
- Session state: `USERINFO`, `psswrdStts`.

Validations:
- non-empty user/password/location.
- locked user threshold via DB function.

Business rule location:
- Java action/DAO + DB query function.

Transaction boundary:
- DB writes on login-attempt updates in DAO.

Uncertainty:
- Full account lock lifecycle and unlock path not fully traced in this pass.

### Flow 2: Change password
- Confidence: **Confirmed from code/config**
1. Main page action/JS routes user to ChangePwd screen.
2. `ChangePwd.jsp` JS validates client-side (new != old, confirm match).
3. Form submits `/ChangePwd.do` with `hdnAction="Change Password"`.
4. `ChangePwdAction` checks active session `USERINFO`, validates password strength checker, hashes old/new with MD5.
5. `ChangePwdDAO.setPwd` runs update against `sysadmin_user_mst` where old hash matches and status active.
6. Success/failure message returned to same JSP.

Business rules:
- partly in JSP JS, partly in `PasswordStrengthChker`, partly in SQL where clause.

Uncertainty:
- strength checker implementation details not inspected in this pass.

### Flow 3: Problem report save
- Confidence: **Confirmed from code/config**
1. User fills screen/problem/cause in `ProblemReport.jsp` and clicks Save.
2. JS sets `hdnAction=Save` and submits `/Problem.do`.
3. `ProblemReportAction` enriches VO with `USERINFO` context.
4. DAO executes insert to `sysadmin_problem_report` using `get_id(...)` function.
5. Success message displayed; form reset.

### Flow 4: Leave Master maintenance
- Confidence: **Confirmed from code/config**
1. User clicks Query/Insert/Edit/Reset (or selects leave in dropdown).
2. JS sets `sAction` values and submits `/LeaveMastAction.do`.
3. `LeaveMastAction` routes by `sAction`.
4. `LeaveMastBD` delegates to `LeaveMastDAO`.
5. DAO performs string-built SQL insert/update/select on `HRM_LEAVE_MAST`.
6. Page reloads with messages and updated lists.

Risks:
- SQL concatenation with user data in `setVO` method.

---

## 6) Stored procedure dependency report (sampled)

### Confirmed packages/procedures from inspected and indexed call sites
- `pkg_pay_fixed_misc_param.Get_Allow_Value` (login max attempts, validation-oriented/security-sensitive)
- `pkg_payroll_misc.PROC_QUERYEMPLOV_NEW` (user LOV/query)
- `pkg_Payroll_utility_FCI.GET_LOV`, `get_lov_inst` (LOV retrieval)
- `pkg_user_resp.proc_chk_user_valid` (authorization/security)
- `PAYROLL_PKG.*` family (high-volume payroll CRUD/workflow/reporting operations)
- `PKG_POST_JV_TO_GL.Ysp_PostJvToGL` (finance posting)
- `pkg_remit_fci.proc_remit_fci` (remittance)
- `fci_payroll_sequential_pkg.proc_chk_concurrency` (concurrency/transaction integrity)
- `pkg_pension_adjustment.*` (pension domain logic)

### Procedure characteristics
- Mostly **workflow-oriented + transactional** for payroll operations.
- Several are **security-sensitive** (login attempts, user validation, concurrency checks).
- Some are **CRUD-like wrappers** for domain masters.

### Keep vs migrate guidance (initial)
- Keep initially: complex payroll calculations, posting/remittance, concurrency checks, audited financial procedures.
- Candidate to migrate earlier: simple LOV/query procedures and straightforward master-data CRUD where test coverage can be added.

---

## 7) WebLogic dependency report

### Found dependencies
- Web module context root + JSP debug in `weblogic.xml`.
- EJB JNDI name bindings and call-by-reference flags in `weblogic-ejb-jar.xml`.
- EJB 2.1 descriptors with remote/home contracts in `ejb-jar.xml`.
- `web.xml` `ejb-ref` wiring to remote interfaces.

### Classification
- EJB remote/home model + WebLogic JNDI names: **hard dependency**.
- Context-root mapping and descriptor runtime knobs: **replaceable with moderate effort**.
- Debug flag in `weblogic.xml`: **likely obsolete** in modern runtime.

---

## 8) Security review from code structure

### Findings
- **Session/auth checks in actions**: several actions verify `USERINFO` in session before processing.
- **Clickjacking protection present**: `X-FRAME-OPTIONS` set in filter.
- **Host header allowlist** implemented in filter.
- **Password hashing uses MD5** in login/change password paths (weak by modern standards).
- **SQL injection risk**: `LeaveMastDAO.setVO` builds raw SQL with concatenated form values.
- **Hardcoded credentials**: common `ContextProvider` uses fixed principal/password (`admin`/`welcome`) and provider URL.
- **Cookie security handling is custom**: filter sets `SET-COOKIE` header manually for JSESSIONID; behavior should be revalidated against container defaults.

### OWASP-aligned modernization actions
1. Replace MD5 with Argon2id or BCrypt (+ migration strategy for existing hashes).
2. Eliminate SQL string concatenation; enforce prepared statements everywhere.
3. Move all secrets/JNDI credentials to secure vault/env config.
4. Standardize session cookie flags via server config (Secure/HttpOnly/SameSite).
5. Add centralized authorization checks (role-based) at controller/service boundaries.
6. Add security tests for auth, session fixation, host header validation, and input validation.

---

## 9) Migration recommendations

### Is React + Java 17 suitable?
- **Yes**. This is a strong fit for replacing JSP/Struts UI and modernizing backend APIs.

### Backend framework suggestion
- Spring Boot 3.x (Java 17+) with Spring MVC/WebFlux (MVC likely enough), Spring Security, Spring Data/JdbcTemplate.

### Legacy-to-target layer mapping (practical)
- JSP/Struts UI -> React SPA or server-rendered React pages.
- Struts Actions -> REST controllers.
- ActionForms -> request/response DTOs with Bean Validation.
- BusinessDelegates/EJB façades -> Spring services.
- DAO + DBUtilities -> repositories + explicit stored-procedure gateway adapter.

### Stored procedure strategy
- Phase 1: keep critical payroll/accounting procedures intact behind service interfaces.
- Phase 2: migrate selected low-risk master CRUD and simple validation logic from PL/SQL to Java.
- Phase 3: re-evaluate high-complexity procedures with golden dataset regression tests.

### Incremental migration plan
1. Introduce strangler facade: expose selected new APIs while old Struts app still runs.
2. Migrate authentication/session handling first (high security impact).
3. Migrate module-by-module starting with low-risk admin/master screens.
4. Keep shared DB schema stable; add integration contract tests.
5. Replace menu/session navigation with API-driven authorization + route guards.

### Anti-patterns to avoid
- Big-bang rewrite without parity testing.
- Re-embedding business rules in frontend.
- Mixing new and legacy auth semantics without centralized policy.

---

## 10) Mapping legacy to modern stack
- JSP page -> React page/component
- Struts action -> REST controller endpoint
- ActionForm -> request DTO
- EJB/service -> Spring service
- DAO/JDBC -> repository/data access layer
- procedure call -> explicit DB gateway adapter
- session-based flow -> token/session policy via Spring Security + modern cookie controls
- WebLogic descriptor -> Spring external config + container/orchestrator manifests

---

## 11) Gaps and open questions

### Unresolved in this pass
- Full trace of all dynamic menu items from generated script entries to concrete endpoints.
- Complete role/permission model and ScreenPermit mappings.
- Exhaustive stored-procedure inventory linked to every UI action.
- Runtime datasource/JNDI config from environment (outside repo).

### Next files to inspect (priority order)
1. `public_html/WEB-INF/struts-config.xml` around menu-linked actions and `RedirectMap` behavior.
2. `COMMON/WEBTIER/Action/RedirectAction.java` and screen permit actions.
3. `COMMON/JSP/menu.jsp` generated dynamic menu payload source (`MainPageDAO.getDyanmicMenu`).
4. EJB facade beans (`PayrollFacadeBean`, `PayrollNewFacadeBean`, `LabourFacadeBean`) and representative business objects.
5. Procedure-heavy business classes under `Payroll/EJB/business/*` grouped by critical journeys (payroll run, approvals, posting).
6. Auth/security-related classes: `LoginServlet`, `ControllerFilter`, session listeners, password reset/upload flows.
7. DB schema/package source (if available externally) for top procedures.

---

## Appendix: key assumptions explicitly marked
- **Strongly inferred**: most payroll operational screens likely use generic base actions + EJB business objects + procedure calls pattern seen repeatedly in mappings/callProc usage.
- **Unresolved**: exact transactional boundaries for each payroll batch job until specific business object methods are traced in detail.
