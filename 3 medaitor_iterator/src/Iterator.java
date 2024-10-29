import java.util.Stack;


    class TreeNode<T> {
        T value;
        TreeNode<T> left;
        TreeNode<T> right;

        public TreeNode(T value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    class BinaryTreeIterator<T> implements java.util.Iterator<T> {
        private Stack<TreeNode<T>> stack;
        private TreeNode<T> root;

        public BinaryTreeIterator(TreeNode<T> root) {
            if (root == null) {
                throw new NullPointerException();
            } else {
                stack = new Stack<>();
                stack.push(root);  // Dodajemy korzeń jako pierwszy węzeł do odwiedzenia
                this.root = root;
            }

        }



        public T first() {
            if ( root == null ) {
                return null ;
            } else {
                return root.value ;
            }
        }


        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public T next() {

            TreeNode<T> node = stack.pop();


            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }


            return node.value;
        }


    }


