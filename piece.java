public class piece {
    private String marker;
    private int yCor;
    private int xCor;
    private boolean isKing;

    public piece(){
        marker = "-1";
    }
    public piece(String m, int x, int y, boolean king){
        marker = m;
        yCor = x;
        xCor = y;
        isKing = king;

    }

    public String getMarker() {
        return marker;
    }
    public int getXCor(){
        return xCor;
    }
    public int getYCor(){
        return yCor;
    }
    public boolean getKing(){
        return isKing;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }
    public void setxCor(int x){
        xCor = x;
    }
    public void setyCor(int y){
        yCor = y;
    }
    public void setKing(boolean king){
        isKing = king;
    }

    public String toString(){
        return marker;
    }
    public void printStuff(){
        System.out.println("print");
    }
}