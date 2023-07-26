package 비교리뷰;
import java.util.Comparator;

public class BinTree<K,V> {
    static class Node<K,V>{
        private K key;
        private V value;
        private Node<K,V> left;
        private Node<K,V> right;
        
        public Node(K key, V value, Node<K, V> left, Node<K, V> right) {
            super();
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
        public Node(K key, V value) {
            this(key, value, null, null);
        }
        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
        @Override
        public String toString() {
            return "K:"+key+",V:"+value+",LEFT:"+left+",RIGHT:"+right;
        }
    }
    private Node<K,V> root;
    private Comparator<? super K> comparator;
    

    private void add(K key, V value) {
        if(root==null) {
            root = new Node<K, V>(key, value);
        }else {
            addNode(root, key, value);
        }
    }

    private void addNode(Node<K, V> node, K key, V value) {
        //node의 키값보다 작으면 LEFT, 아니면 RIGHT 저장
        int cond = comp(key, node.getKey());
        if(cond==0)
            return; //동일키가 이미 등록
        if(cond < 0) {//왼쪽에 저장
            if(node.left==null) {
                node.left = new Node<K, V>(key, value);
            }
            else {
                addNode(node.left, key, value);
            }
        }else {//오른쪽 저장
            if(node.right==null) {
                node.right = new Node<K, V>(key, value);
            }
            else {
                addNode(node.right, key, value);
            }
        }
    }//end addNode()

    private int comp(K key1, K key2) {
        return (comparator==null)?
                    ( ((Comparable<K>)key1).compareTo(key2)):
                            (comparator.compare(key1, key2));
    }
    
    public static void main(String[] args) {
        BinTree<Integer, String> tr = new BinTree<Integer, String>();
        //등록
        Node<Integer, String> nd = new Node<Integer, String>(1, "홍길동");
        tr.add( nd.getKey(), nd.getValue() );
        nd = new Node<Integer, String>(3, "김길동");
        tr.add( nd.getKey(), nd.getValue() );
        nd = new Node<Integer, String>(2, "박길동");
        tr.add( nd.getKey(), nd.getValue() );
    }
    
}