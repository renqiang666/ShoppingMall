function encr(data) {

    var key = CryptoJS.enc.Latin1.parse('class33iamironma');
    var iv = CryptoJS.enc.Latin1.parse('iamironmaclass33');

    //加密
    var encrypted = CryptoJS.AES.encrypt(data, key, {
        iv: iv,
        mode: CryptoJS.mode.CBC,
        padding: CryptoJS.pad.ZeroPadding
    });
    

    return encrypted.toString();
}
//解密
function decr(data) {
    var key = CryptoJS.enc.Latin1.parse('class33iamironma');
    var iv = CryptoJS.enc.Latin1.parse('iamironmaclass33');
    var decrypted = CryptoJS.AES.decrypt(data, key, {iv: iv, padding: CryptoJS.pad.ZeroPadding});
    return decrypted.toString(CryptoJS.enc.Utf8);
}
