class ProductOfNumbers {

    private Set<Integer> st;
    private List<Integer> preProd;
    private Integer prod;

    public ProductOfNumbers() {
        this.preProd = new ArrayList<>();
        this.prod = 1;
    }
    
    public void add(int num) {
        if(num == 0){
            preProd = new ArrayList<>();
            prod = 1;
            preProd.add(prod);
        } else {
            prod = prod * num;
            preProd.add(prod);
        }
    }
    
    public int getProduct(int k) {
        if(k > preProd.size() - 1){
            return 0;
        }

        int start = preProd.size() - 1 - k;
        int end = preProd.size() - 1;
        return preProd.get(end) / preProd.get(start);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */