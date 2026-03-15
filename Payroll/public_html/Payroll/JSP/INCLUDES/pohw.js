function getSafeValue(id) {
    var el = document.getElementById(id);
    return el ? el.value : "";
}

// pohw.js

function enablepohw(epsFlag) {
    var pohwFlag = getSafeValue("txtPohwFlag");

    // If EPS = N ? POHW must always be locked
    if (epsFlag === "N") {
        lockField("txtPohwFlag");
    } 
    // If EPS = Y or P ? only lock if POHW = Y
    else if ((epsFlag === "Y" || epsFlag === "P") && pohwFlag === "Y") {
        lockField("txtPohwFlag");
    } 
    else {
        unlockField("txtPohwFlag");
    }

    // Always keep txtPohwEffDt locked
    lockField("txtPohwEffDt");
}

function changePohwDate(pohwFlag) {
    // txtPohwEffDt must always be locked
    lockField("txtPohwEffDt");
}

function handlePohwOnLoad() {
    var epsFlag = getSafeValue("txtEpsFlag");
    var pohwFlag = getSafeValue("txtPohwFlag");
    lockField("txtEpsFlag"); 
    // EPS = N ? always lock POHW
    if (epsFlag === "N") {
        lockField("txtPohwFlag");
    } 
    // EPS = Y or P ? lock POHW only if POHW=Y
    else if ((epsFlag === "Y" || epsFlag === "P") && pohwFlag === "Y") {
        lockField("txtPohwFlag");
    } 
    else {
        unlockField("txtPohwFlag");
    }

    // Always keep txtPohwEffDt locked
    lockField("txtPohwEffDt");
}

// ---- Utility Functions ----
function lockField(id) {
    var el = document.getElementById(id);
    if (!el) return;
    el.disabled = true;
    el.readOnly = true;
    el.style.background = "#e0e0e0";
    el.className = "locked";
}

function unlockField(id) {
    var el = document.getElementById(id);
    if (!el) return;
    el.disabled = false;
    el.readOnly = false;
    el.style.background = "";
    el.className = "";
}
