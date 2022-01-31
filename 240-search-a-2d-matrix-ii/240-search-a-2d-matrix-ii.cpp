class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int s_r=0, s_c=0;
        while(1){
            //cout<<s_r<<" "<<s_c<<endl;
            if(s_r >= matrix.size()){
                break;
            }
            if(s_c >= matrix[0].size()){
                break;
            }
            if(matrix[s_r][s_c]==target){
                return true;
            }
            if((s_r+1 < matrix.size() && s_c+1 < matrix[0].size())){
                if(matrix[s_r+1][s_c] == target){
                    return true;
                }
                if(matrix[s_r][s_c+1] == target){
                    return true;
                }
                if(matrix[s_r+1][s_c] < target && matrix[s_r][s_c+1] < target){
                    if(matrix[s_r+1][s_c] <= matrix[s_r][s_c+1]){
                        s_r=s_r+1;
                        continue;
                    }else{
                        s_c=s_c+1;
                        continue;
                    }
                }else if(matrix[s_r+1][s_c] < target){
                    s_r=s_r+1;
                    continue;
                }else if(matrix[s_r][s_c+1] < target){
                    s_c=s_c+1;
                    continue;
                }else{
                    // upar jana hai
                    while(1){
                        if(s_r-1 < 0){
                            break;
                        }
                        if(s_c+1 >= matrix[0].size()){
                            break;
                        }
                        if(matrix[s_r-1][s_c+1] > target){
                            s_r-=1;
                            continue;
                        }
                        break;
                    }
                    
                    s_r-=1;
                    if(s_r < 0){
                        break;
                    }
                    if(matrix[s_r][s_c]==target){
                        return true;
                    }
                    s_c+=1;
                    continue;
                }
            }else if(s_r+1 < matrix.size()){
                if(matrix[s_r+1][s_c] == target){
                    return true;
                }
                if(matrix[s_r+1][s_c] < target)
                    s_r=s_r+1;
                else{
                    // upar jana hai
                    while(1){
                        if(s_r-1 < 0){
                            break;
                        }
                        if(s_c+1 >= matrix[0].size()){
                            break;
                        }
                        if(matrix[s_r-1][s_c+1] > target){
                            s_r-=1;
                            continue;
                        }
                        break;
                    }
                    
                    s_r-=1;
                    if(s_r < 0){
                        break;
                    }
                    if(matrix[s_r][s_c]==target){
                        return true;
                    }
                    s_c+=1;
                    continue;
                }
            }else if(s_c+1 < matrix[0].size()){
                if(matrix[s_r][s_c+1] == target){
                    return true;
                }
                if(matrix[s_r][s_c+1] < target)
                    s_c=s_c+1;
                else{
                    // upar jana hai
                    while(1){
                        if(s_r-1 < 0){
                            break;
                        }
                        if(s_c+1 >= matrix[0].size()){
                            break;
                        }
                        if(matrix[s_r-1][s_c+1] > target){
                            s_r-=1;
                            continue;
                        }
                        break;
                    }
                    
                    s_r-=1;
                    if(s_r < 0){
                        break;
                    }
                    if(matrix[s_r][s_c]==target){
                        return true;
                    }
                    s_c+=1;
                    continue;
                }
            }else{
                break;
            }    
        }
        
        s_r=0;
        s_c=0;
        while(1){
            //cout<<s_r<<" "<<s_c<<endl;
            if(s_r >= matrix.size()){
                break;
            }
            if(s_c >= matrix[0].size()){
                break;
            }
            if(matrix[s_r][s_c]==target){
                return true;
            }
            if((s_r+1 < matrix.size() && s_c+1 < matrix[0].size())){
                if(matrix[s_r+1][s_c] == target){
                    return true;
                }
                if(matrix[s_r][s_c+1] == target){
                    return true;
                }
                if(matrix[s_r+1][s_c] < target && matrix[s_r][s_c+1] < target){
                    if(matrix[s_r+1][s_c] <= matrix[s_r][s_c+1]){
                        s_r=s_r+1;
                        continue;
                    }else{
                        s_c=s_c+1;
                        continue;
                    }
                }else if(matrix[s_r+1][s_c] < target){
                    s_r=s_r+1;
                    continue;
                }else if(matrix[s_r][s_c+1] < target){
                    s_c=s_c+1;
                    continue;
                }else{
                    // piche jana hai
                    while(1){
                        if(s_c-1 < 0){
                            break;
                        }
                        if(s_r+1 >= matrix.size()){
                            break;
                        }
                        if(matrix[s_r+1][s_c-1] > target){
                            s_c-=1;
                            continue;
                        }
                        break;
                    }
                    
                    s_c-=1;
                    if(s_c < 0){
                        break;
                    }
                    if(matrix[s_r][s_c]==target){
                        return true;
                    }
                    s_r+=1;
                    continue;
                }
            }else if(s_r+1 < matrix.size()){
                if(matrix[s_r+1][s_c] == target){
                    return true;
                }
                if(matrix[s_r+1][s_c] < target)
                    s_r=s_r+1;
                else{
                    // upar jana hai
                    while(1){
                        if(s_c-1 < 0){
                            break;
                        }
                        if(s_r+1 >= matrix.size()){
                            break;
                        }
                        if(matrix[s_r+1][s_c-1] > target){
                            s_c-=1;
                            continue;
                        }
                        break;
                    }
                    
                    s_c-=1;
                    if(s_c < 0){
                        break;
                    }
                    if(matrix[s_r][s_c]==target){
                        return true;
                    }
                    s_r+=1;
                    continue;
                }
                continue;
            }else if(s_c+1 < matrix[0].size()){
                if(matrix[s_r][s_c+1] == target){
                    return true;
                }
                if(matrix[s_r][s_c+1] < target)
                    s_c=s_c+1;
                else{
                    // upar jana hai
                    while(1){
                        if(s_c-1 < 0){
                            break;
                        }
                        if(s_r+1 >= matrix.size()){
                            break;
                        }
                        if(matrix[s_r+1][s_c-1] > target){
                            s_c-=1;
                            continue;
                        }
                        break;
                    }
                    
                    s_c-=1;
                    if(s_c < 0){
                        break;
                    }
                    if(matrix[s_r][s_c]==target){
                        return true;
                    }
                    s_r+=1;
                    continue;
                }
                continue;
            }else{
                break;
            }    
        }
        return false;
    }
};