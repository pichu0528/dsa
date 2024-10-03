// Online Javascript Editor for free
// Write, Edit and Run your Javascript code using JS Online Compiler

function myMergeSort(arr) {
    if (arr.length === 1) return arr;
    
    
    const left = arr.slice(0, Math.floor(arr.length / 2));
    const right = arr.slice(Math.floor(arr.length / 2));
    
    const leftArr = myMergeSort(left);
    const rightArr = myMergeSort(right);
    let temp = [];
    let i = 0
    let j = 0;
    
    while(i < leftArr.length && j < rightArr.length) {
        if (leftArr[i] > rightArr[j]) {
            temp.push(rightArr[j]);
            j++;
        } else {
            temp.push(leftArr[i]);
            i++;
        }
    }
    
    let [remainingArr, remainingIndex] = i < leftArr.length ? [leftArr, i] : [rightArr, j];
    
    temp = [...temp, ...remainingArr.slice(remainingIndex)];
    
    return temp;
};

console.log('------');
console.log('final arr:', myMergeSort([3000, 20, 35, -15, 7, 55, 1, -22, 1]));
