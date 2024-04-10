package suncodes.structure.search;

/**
 * 树表查找
 */
public class TreeTableLookup {
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 10, 14, 19, 26, 28, 31, 33, 37, 42, 48};
        TreeNode treeNode = sortedArrayToBST(arr, 0, arr.length);
        System.out.println(treeTableSearch(treeNode, 33));
    }

    /**
     * 二叉树查找
     * @param treeNode
     * @param findVal
     * @return
     */
    public static int treeTableSearch(TreeNode treeNode, int findVal) {
        if (treeNode == null) {
            return -1;
        }
        int value = treeNode.getValue();
        if (findVal == value) {
            return treeNode.getIndex();
        }
        if (findVal < value) {
            return treeTableSearch(treeNode.getLeft(), findVal);
        }
        return treeTableSearch(treeNode.getRight(), findVal);
    }

    /**
     * 根据有序数据创建平衡二叉树
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public static TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left >= right) {
            return null;
        }
        if (right - left == 1) {
            return new TreeNode(nums[left], left);
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid], mid);
        root.left = sortedArrayToBST(nums, left, mid);
        root.right = sortedArrayToBST(nums, mid + 1, right);
        return root;
    }

    public static class TreeNode {
        private int value;
        private int index;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int value, int index) {
            this.value = value;
            this.index = index;
        }
        public TreeNode getLeft() {
            return left;
        }
        public void setLeft(TreeNode left) {
            this.left = left;
        }
        public TreeNode getRight() {
            return right;
        }
        public void setRight(TreeNode right) {
            this.right = right;
        }
        public int getValue() {
            return value;
        }
        public void setValue(int value) {
            this.value = value;
        }
        public void setIndex(int index) {
            this.index = index;
        }
        public int getIndex() {
            return index;
        }
        @Override
        public String toString() {
            return "TreeNode [value=" + value + "]";
        }
    }
}
