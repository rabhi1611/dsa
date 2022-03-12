class Solution {
public:
    int maximumSwap(int num) {
    string temp = to_string(num);
    int maxIdx, maxNum = 0, leftIdx=-1, rightIdx;
    
    for (int i = temp.size()-1; i>=0; i--) {
        int t = temp[i]-'0';
        if (t > maxNum) {
            maxNum = t;
            maxIdx = i;
        } else if (t < maxNum) {
            leftIdx = i;
            rightIdx = maxIdx;
        }
    }

    if (leftIdx == -1)
        return num;
    
    swap(temp[leftIdx], temp[rightIdx]);
    return stoi(temp);
}
};