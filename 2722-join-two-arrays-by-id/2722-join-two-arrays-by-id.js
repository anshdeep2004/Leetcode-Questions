/**
 * @param {Array} arr1
 * @param {Array} arr2
 * @return {Array}
 */
var join = function(arr1, arr2) {
    let joinedArr = []
    let m = new Map();
    for(let i=0; i<arr1.length; i++){
        joinedArr.push(arr1[i]);
        m.set(arr1[i].id, i);
    }

    for(let i=0; i<arr2.length; i++){
        let idx = m.get(arr2[i].id)
        if(idx != undefined){
            joinedArr[idx] = {...joinedArr[idx], ...arr2[i]};
        }else{
            joinedArr.push(arr2[i])
        }
    }
    joinedArr.sort((a,b)=>{
        return a.id-b.id;
    });
    return joinedArr;
};