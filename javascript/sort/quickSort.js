function partition(arr, start, end) {
    const pivotElement = arr[start];
    let i = start;
    let j = end;

    while (i < j) {
        while (i < j && arr[--j] >= pivotElement);
        if (i < j) {
            arr[i] = arr[j];
        }

        while (i < j && arr[++i] <= pivotElement);
        if (i < j) {
            arr[j] = arr[i];
        }
    }

    arr[j] = pivotElement;
    return j;
}

function mergeSort(arr, i, j) {
    if (j - i < 2) return;

    const partitionIndex = partition(arr, i, j);
    mergeSort(arr, i, partitionIndex);
    mergeSort(arr, partitionIndex + 1, j);
}

const arr = [20, 35, -15, 7, 55, 1, -22];
mergeSort(arr, 0, 7);

console.log('arr', arr);