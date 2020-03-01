class TwoRectangleOverlap {

    class Point{
        int x;
        int y;
    
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        TwoRectangleOverlap outer = new TwoRectangleOverlap();
        TwoRectangleOverlap.Point l2 = outer.new Point(0, 4);
        TwoRectangleOverlap.Point r2 = outer.new Point(3, 0);
        TwoRectangleOverlap.Point l1 = outer.new Point(2, 6);
        TwoRectangleOverlap.Point r1 = outer.new Point(5, 3);
        Boolean ret = ifOverlap(l1, r1, l2, r2);
        System.out.println(ret);
    }

    public static Boolean ifOverlap(Point l1, Point r1, Point l2, Point r2) {
        // left or right no overlap
        if (r1.x < l2.x || r2.x < l1.x) {
            return false;
        }
        // top or bottom no overlap
        if (r1.y > l2.y || r2.y > l1.y) {
            return false;
        }
        return true;
    }

}