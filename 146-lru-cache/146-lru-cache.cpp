class node{
  public:
    int key;
    int value;
    node* prev;
    node* next;
    node(int key, int value){
        this->key=key;
        this->value=value;
        this->prev=NULL;
        this->next=NULL;
    }
};

class LRUCache {
public:
    node * head=new node(-1,-1);
    node * tail=new node(-1,-1);
    int capacity;
    unordered_map<int,node*>m;
    LRUCache(int capacity) {
        this->capacity=capacity;
        tail->next=head;
        tail->prev=head;
        head->next=tail;
        head->prev=tail;
    }
    
    void add_node(int key, int value){
        node* p=new node(key,value);
        node* temp=head->next;
        temp->prev=p;
        head->next=p;
        p->prev=head;
        p->next=temp;
        temp=NULL;
        m[key]=p;
    }
    
    void delete_node(node* t){
        node* p_node=t->prev;
        node* n_node=t->next;
        p_node->next=t->next;
        n_node->prev=t->prev;
        delete t;
        t=NULL;
    }
    
    int get(int key) {
        if(m.count(key)>0){
            node* p=m[key];
            add_node(p->key,p->value);
            delete_node(p);
            p=NULL;
            return m[key]->value;
        }
        return -1;
    }
    
    void put(int key, int value) {
        if(m.count(key)>0){
            node *p=m[key];
            p->value=value;
            add_node(p->key,p->value);
            delete_node(p);
        }else{
            if(m.size()==capacity){
                int k=tail->prev->key;
                delete_node(tail->prev);
                m.erase(k);
            }
            add_node(key,value);
        }
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */