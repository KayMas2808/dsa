class Node {
    Node[] links;
    boolean flag;

    Node() {
        links = new Node[26];
        flag = false;
    }

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    void put(char ch) {
        links[ch - 'a'] = new Node();
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    void setEnd() {
        flag = true;
    }

    boolean isEnd() {
        return flag;
    }
}

class Trie {
    Node root;

    Trie() {
        root = new Node();
    }

    void insert(String word) {
        Node ins = root;
        for (int i = 0; i < word.length(); i++) {
            if (!ins.containsKey(word.charAt(i))) {
                ins.put(word.charAt(i));
            }
            ins = ins.get(word.charAt(i));
        }
        ins.setEnd();
    }

    boolean search(String word) {
        Node sea = root;
        for (int i = 0; i < word.length(); i++) {
            if (!sea.containsKey(word.charAt(i))) {
                return false;
            }
            sea = sea.get(word.charAt(i));
        }
        return sea.isEnd();
    }

    boolean startsWith(String prefix) {
        Node st = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!st.containsKey(prefix.charAt(i))) {
                return false;
            }
            st = st.get(prefix.charAt(i));
        }
        return true;
    }
}
