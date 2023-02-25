function isAlphanumeric(code: number) {
    // digits: 48-57
    // lowercase letters: 97-122 
    return ((code >= 48 && code <= 57) || (code >= 97 && code <= 122)) 
}

function isPalindrome(s: string): boolean {
    s = s.toLowerCase();
    let start : number = 0, end : number = s.length - 1;
    
    while(start < end) {
        let iCode = s.charCodeAt(start);
        let jCode = s.charCodeAt(end);
      

      while(!isAlphanumeric(iCode)) {
           start++;
      }

      while(!isAlphanumeric(jCode)) {
           end--;
      }


      if(s.charAt(start++) !== s.charAt(end--)) {
        return false;
      }
    }
    
    return true;
};