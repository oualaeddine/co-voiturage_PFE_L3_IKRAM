// Analog Clock - Head Script
// copyright Stephen Chapman, 19th November 2005, 28th September 2008
// you may copy this clock provided that you retain the copyright notice
var dayname = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'];
var am = 'AM';
var pm = 'PM';

// you should not need to alter the below code
var pi = Math.PI;
var d = document;
var pi2 = pi / 2;
var rad = (+clocksize) / 2;
var ctrX = (+xpos) + rad;
var ctrY = (+ypos) + rad;
var hourln = 1;
var minln = secln = 2;
for (var i = 0; i < (rad / 2) + (rad / 16); i++) {
    hourln += 1;
}
for (var i = 0; i < (rad / 2) - (rad / 8); i++) {
    minln += 2;
    secln += 2;
}
var font_size = rad / 4;
var offset = 16;
var clocknum = [[, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12], [, 'I', 'II', 'III', 'IIII', 'V', 'VI', 'VII', 'VIII', 'IX', 'X', 'XI', 'XII'], [, '·', '·', '-', '·', '·', '<span style="font-size:60%">|</span>', '·', '·', '-', '·', '·', '<span style="font-size:60%">||</span>']];
if (numstyle < 0 || numstyle > 2) numstyle = 0;

function timeZone(now, loc, mtz, dst) {
    if (loc) {
        var dow = now.getDay();
        var second = now.getSeconds();
        var minute = now.getMinutes();
        var hour = now.getHours();
    } else {
        now.setUTCMinutes(now.getUTCMinutes() + (mtz + dst) * 60);
        var dow = now.getUTCDay();
        var second = now.getUTCSeconds();
        var minute = now.getUTCMinutes();
        var hour = now.getUTCHours();
    }
    if (hour > 11) {
        moa = pm;
        hour -= 12;
    } else moa = am;
    return [dow, moa, hour, minute, second];
}

function commonClock(n) {
    n.style.position = 'absolute';
    n.style.top = '0';
    n.style.left = '0';
    n.style.visibility = 'hidden';
}

function displayClock() {
    if (!d.getElementById) return;
    var ctx = document.createElement('div');
    if (fix) {
        ctx.style.position = 'relative';
        ctx.style.margin = 'auto';
        ctx.style.width = (clocksize + offset * 2) + 'px';
        ctx.style.height = (clocksize + offset * 2) + 'px';
        ctx.style.overflow = 'visible';
    }
    var cn = [];
    for (var i = 12; i > 0; i--) {
        cn[i] = document.createElement('div');
        cn[i].id = 'cnum' + i;
        commonClock(cn[i]);
        cn[i].style.width = (offset * 2) + 'px';
        cn[i].style.height = (offset * 2) + 'px';
        cn[i].style.fontFamily = font_family;
        cn[i].style.fontSize = font_size + 'px';
        cn[i].style.color = '#' + colnumbers;
        cn[i].style.textAlign = 'center';
        cn[i].style.paddingTop = '10px';
        cn[i].style.zIndex = 1000;
        cn[i].innerHTML = clocknum[numstyle][i];
        ctx.appendChild(cn[i]);
    }
    var mn = [];
    for (i = minln; i > 0; i--) {
        mn[i] = document.createElement('div');
        mn[i].id = 'cmin' + i;
        commonClock(mn[i]);
        mn[i].style.width = '1px';
        mn[i].style.height = '1px';
        mn[i].style.fontSize = '1px';
        mn[i].style.backgroundColor = '#' + colminutes;
        mn[i].style.zIndex = 997;
        ctx.appendChild(mn[i]);
    }
    var hr = [];
    for (i = hourln; i > 0; i--) {
        hr[i] = document.createElement('div');
        hr[i].id = 'chour' + i;
        commonClock(hr[i]);
        hr[i].style.width = '2px';
        hr[i].style.height = '2px';
        hr[i].style.fontSize = '2px';
        hr[i].style.backgroundColor = '#' + colhours;
        hr[i].style.zIndex = 998;
        ctx.appendChild(hr[i]);
    }
    var sc = [];
    for (i = secln; i > 0; i--) {
        sc[i] = document.createElement('div');
        sc[i].id = 'csec' + i;
        commonClock(sc[i]);
        sc[i].style.width = '1px';
        sc[i].style.height = '1px';
        sc[i].style.fontSize = '1px';
        sc[i].style.backgroundColor = '#' + colseconds;
        sc[i].style.zIndex = 999;
        ctx.appendChild(sc[i]);
    }
    var am = document.createElement('div');
    am.id = 'ampm';
    commonClock(am);
    am.style.width = ((xpos + rad) * 2) + 'px';
    am.style.fontFamily = font_family;
    am.style.fontSize = (font_size * 2 / 3) + 'px';
    am.style.color = '#' + colnumbers;
    am.style.textAlign = 'center';
    am.style.paddingTop = '10px';
    am.style.zIndex = 990;
    ctx.appendChild(am);
    var zn = document.createElement('div');
    zn.id = 'zone';
    commonClock(zn);
    zn.style.width = ((xpos + rad) * 2) + 'px';
    zn.style.fontFamily = font_family;
    zn.style.fontSize = (font_size * 2 / 3) + 'px';
    zn.style.color = '#' + colnumbers;
    zn.style.textAlign = 'center';
    zn.style.paddingTop = '10px';
    zn.style.zIndex = 990;
    ctx.appendChild(zn);
    d.getElementById('clock_a').appendChild(ctx);
    for (var i = 12; i > 0; i--) {
        d.getElementById('cnum' + i).style.top = (ctrY - offset + rad * Math.sin(i * pi / 6 - pi2)) + 'px';
        d.getElementById('cnum' + i).style.left = (ctrX - offset + rad * Math.cos(i * pi / 6 - pi2)) + 'px';
        d.getElementById('cnum' + i).style.visibility = 'visible';
    }
    updateClock();
}

function moveClock(l, e, f) {
    for (var i = l; i > 0; i--) {
        d.getElementById(e + i).style.top = (ctrY + i * Math.sin(f)) + 'px';
        d.getElementById(e + i).style.left = (ctrX + i * Math.cos(f)) + 'px';
        d.getElementById(e + i).style.visibility = 'visible';
    }
}

function updateClock() {
    var now = new Date();
    var theTime = timeZone(now, localZone, mytimezone, dst);
    d.getElementById('ampm').style.top = (ypos + rad / 3) + 'px';
    /*d.getElementById('ampm').innerHTML = theTime[1] + '<br />' + dayname[theTime[0]];*/
    d.getElementById('ampm').style.visibility = 'visible';
    if (!localZone) {
        d.getElementById('zone').style.top = (ctrY + (rad / 10)) + 'px';
        d.getElementById('zone').innerHTML = city + '<br />' + country;
        d.getElementById('zone').style.visibility = 'visible';
    }
    moveClock(secln, 'csec', pi * theTime[4] / 30 - pi2);
    moveClock(minln, 'cmin', pi * theTime[3] / 30 - pi2);
    moveClock(hourln, 'chour', pi * theTime[2] / 6 + pi * (+now.getMinutes()) / 360 - pi2);
    setTimeout('updateClock()', 100);
}

window.onload = displayClock;