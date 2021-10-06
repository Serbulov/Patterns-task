package task.flowerStore.model.flowers;

import java.util.List;

public class WildFlower extends Flower {
    private boolean havingBuild;

    public WildFlower() {
    }

    public WildFlower(String name, double stemLength, List<FlowerColors> colors,
                      double price, double hoursAfterCutOff, boolean havingBuild) {
        super(name, stemLength, colors, price, hoursAfterCutOff);
        this.havingBuild = havingBuild;
    }

    public boolean isHavingBuild() {
        return havingBuild;
    }

    public void setHavingBuild(boolean havingBuild) {
        this.havingBuild = havingBuild;
    }
}
