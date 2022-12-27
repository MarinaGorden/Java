package BinarySearch;

public class LC278_FirstBadVersion {
    int version;
    public LC278_FirstBadVersion(int version){
        this.version = version;
    }

    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        // [left, right)
        while (left < right) {
            int mid = left + (right - left) / 2;
            // mid isn't bad, [left, mid] is not bad
            if (!isBadVersion(mid)){
                // go to the right partition
                left = mid + 1;
            } else right = mid;
        }
        return left;
    }
    public boolean isBadVersion (int n) {
        return n >= version;
    }

    public static void main(String[] args) {
        LC278_FirstBadVersion case1 = new LC278_FirstBadVersion(4);
        System.out.println(case1.firstBadVersion(5));
        LC278_FirstBadVersion case2 = new LC278_FirstBadVersion(1);
        System.out.println(case2.firstBadVersion(1));
        LC278_FirstBadVersion case3 = new LC278_FirstBadVersion(2);
        System.out.println(case3.firstBadVersion(3));
    }
}
