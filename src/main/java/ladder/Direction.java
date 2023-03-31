package ladder;

public enum Direction {
    LEFT{
        @Override
        public int move(int position){
            return position -1;
        }
    },
    RIGHT{
        @Override
        public int move(int position){
            return position +1;
        }
    };
    public abstract int move(int position);
}
