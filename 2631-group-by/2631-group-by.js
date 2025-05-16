/**
 * @param {Function} fn
 * @return {Object}
 */
Array.prototype.groupBy = function(fn) {
    group = {}
    for(let i=0; i<this.length; i++){
        let key = fn(this[i]);
        let arr = group[key];

        if(!arr){
            arr = []  
            group[key] = arr;  // group[key] points to arr   
        }
        
        arr.push(this[i])  // hence pushing to arr works or you can also push to group[key] .
    }
    return group;
};

/**
 * [1,2,3].groupBy(String) // {"1":[1],"2":[2],"3":[3]}
 */