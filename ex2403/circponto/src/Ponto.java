public class Ponto {
    int x, y;

    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }

    private void setX(int x) {
        this.x = x;
    }

    private void setY(int y) {
        this.y = y;
    }

    public Ponto(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public double dist(int x, int y){
        return Math.sqrt((this.x - x)*(this.x - x) + (this.y - y)*(this.y - y));
    }
}

