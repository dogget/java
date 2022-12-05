

public enum Seasons{
    WINTER(-6),
    SPRING(+7),
    SUMMER(+20) {
        @Override
        public String getDescription() {
            return "Warm season";
        }
    },
    AUTUMN(+10);
    private final int averageTemperature;
    Seasons(int averageTemperature){
        this.averageTemperature = averageTemperature;
    }
    public int getAverageTemperature(){
        return averageTemperature;
    }
    public String getDescription(){
        return "Cold season";
    }
}
