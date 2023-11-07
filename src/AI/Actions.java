package AI;

public class Actions {
   // in any action return null if it can't be performed according to the rules
    public static Node requestFood(Node input, boolean visualize) {
        if(input.getState().getCurrentFoodDelay()!=-1 || input.getState().getCurrentEnergyDelay()!=-1 || input.getState().getCurrentMaterialsDelay()!=-1)
            return null;
        State newState = input.getState();
        int MoneySpent=newState.getUnitPriceEnergy()+newState.getUnitPriceFood()+newState.getUnitPriceMaterials();
        newState.setMoneySoFar(newState.getMoneySoFar()+MoneySpent);
        if(newState.getMoneySoFar()>100000)
            return null;
        newState.setCurrentEnergy(newState.getCurrentEnergy()-newState.getUnitPriceEnergy());
        newState.setCurrentFood(newState.getCurrentFood()-newState.getUnitPriceFood());
        newState.setCurrentMaterials(newState.getCurrentMaterials()-newState.getUnitPriceMaterials());
        if(newState.getCurrentEnergy()<0 || newState.getCurrentFood()<0 || newState.getCurrentMaterials()<0)
            return null;
        newState.setCurrentFoodDelay(newState.getDelayRequestFood());
        AI.Node newNode = new AI.Node(newState, input, Operator.REQUEST_FOOD, input.getDepth() + 1, MoneySpent, 0);
        return newNode;
    }
    public static Node requestMaterials(Node input,boolean visualize) {
        if(input.getState().getCurrentFoodDelay()!=-1 || input.getState().getCurrentEnergyDelay()!=-1 || input.getState().getCurrentMaterialsDelay()!=-1)
            return null;
        State newState = input.getState();
        int MoneySpent=newState.getUnitPriceEnergy()+newState.getUnitPriceFood()+newState.getUnitPriceMaterials();
        newState.setMoneySoFar(newState.getMoneySoFar()+MoneySpent);
        if(newState.getMoneySoFar()>100000)
            return null;
        newState.setCurrentEnergy(newState.getCurrentEnergy()-newState.getUnitPriceEnergy());
        newState.setCurrentFood(newState.getCurrentFood()-newState.getUnitPriceFood());
        newState.setCurrentMaterials(newState.getCurrentMaterials()-newState.getUnitPriceMaterials());
        if(newState.getCurrentEnergy()<0 || newState.getCurrentFood()<0 || newState.getCurrentMaterials()<0)
            return null;
        newState.setCurrentMaterialsDelay(newState.getDelayRequestMaterials());
        AI.Node newNode = new AI.Node(newState, input, Operator.REQUEST_MATERIALS, input.getDepth() + 1, MoneySpent, 0);
        return newNode;
    }
    public static Node requestEnergy(Node input,boolean visualize) {
        if(input.getState().getCurrentFoodDelay()!=-1 || input.getState().getCurrentEnergyDelay()!=-1 || input.getState().getCurrentMaterialsDelay()!=-1)
            return null;
        State newState = input.getState();
        int MoneySpent=newState.getUnitPriceEnergy()+newState.getUnitPriceFood()+newState.getUnitPriceMaterials();
        newState.setMoneySoFar(newState.getMoneySoFar()+MoneySpent);
        if(newState.getMoneySoFar()>100000)
            return null;
        newState.setCurrentEnergy(newState.getCurrentEnergy()-newState.getUnitPriceEnergy());
        newState.setCurrentFood(newState.getCurrentFood()-newState.getUnitPriceFood());
        newState.setCurrentMaterials(newState.getCurrentMaterials()-newState.getUnitPriceMaterials());
        if(newState.getCurrentEnergy()<0 || newState.getCurrentFood()<0 || newState.getCurrentMaterials()<0)
            return null;
        newState.setCurrentEnergyDelay(newState.getDelayRequestEnergy());
        AI.Node newNode = new AI.Node(newState, input, Operator.REQUEST_ENERGY, input.getDepth() + 1, MoneySpent, 0);
        return newNode;
    }
    public static Node wait(Node input,boolean visualize) {
        State newState = input.getState();
        int MoneySpent=newState.getUnitPriceEnergy()+newState.getUnitPriceFood()+newState.getUnitPriceMaterials();
        newState.setMoneySoFar(newState.getMoneySoFar()+MoneySpent);
        if(newState.getMoneySoFar()>100000)
            return null;
        newState.setCurrentEnergy(newState.getCurrentEnergy()-newState.getUnitPriceEnergy());
        newState.setCurrentFood(newState.getCurrentFood()-newState.getUnitPriceFood());
        newState.setCurrentMaterials(newState.getCurrentMaterials()-newState.getUnitPriceMaterials());
        if(newState.getCurrentEnergy()<0 || newState.getCurrentFood()<0 || newState.getCurrentMaterials()<0)
            return null;
        newState.setCurrentFoodDelay(newState.getCurrentFoodDelay()-1);
        newState.setCurrentMaterialsDelay(newState.getCurrentMaterialsDelay()-1);
        newState.setCurrentEnergyDelay(newState.getCurrentEnergyDelay()-1);
        AI.Node newNode = new AI.Node(newState, input, Operator.WAIT, input.getDepth() + 1, MoneySpent, 0);
        return newNode;
    }
    public static Node build1(Node input,boolean visualize) {
        State newState = input.getState();
        int MoneySpent=newState.getUnitPriceEnergy()+newState.getUnitPriceFood()+newState.getUnitPriceMaterials()+newState.getPriceBUILD1();
        newState.setMoneySoFar(newState.getMoneySoFar()+MoneySpent);
        if(newState.getMoneySoFar()>100000)
            return null;
        newState.setCurrentProsperity(newState.getCurrentProsperity()+newState.getProsperityBUILD1());
        newState.setCurrentEnergy(newState.getCurrentEnergy()-newState.getEnergyUseBUILD1());
        newState.setCurrentFood(newState.getCurrentFood()-newState.getFoodUseBUILD1());
        newState.setCurrentMaterials(newState.getCurrentMaterials()-newState.getMaterialsUseBUILD1());
        if(newState.getCurrentEnergy()<0 || newState.getCurrentFood()<0 || newState.getCurrentMaterials()<0)
            return null;
        newState.setCurrentFoodDelay(newState.getCurrentFoodDelay()-1);
        newState.setCurrentMaterialsDelay(newState.getCurrentMaterialsDelay()-1);
        newState.setCurrentEnergyDelay(newState.getCurrentEnergyDelay()-1);
        AI.Node newNode = new AI.Node(newState, input, Operator.BUILD_1, input.getDepth() + 1, MoneySpent, 0);
        return newNode;
    }
    public static Node build2(Node input,boolean visualize) {
        State newState = input.getState();
        int MoneySpent=newState.getUnitPriceEnergy()+newState.getUnitPriceFood()+newState.getUnitPriceMaterials()+newState.getPriceBUILD2();
        newState.setMoneySoFar(newState.getMoneySoFar()+MoneySpent);
        if(newState.getMoneySoFar()>100000)
            return null;
        newState.setCurrentProsperity(newState.getCurrentProsperity()+newState.getProsperityBUILD2());
        newState.setCurrentEnergy(newState.getCurrentEnergy()-newState.getEnergyUseBUILD2());
        newState.setCurrentFood(newState.getCurrentFood()-newState.getFoodUseBUILD2());
        newState.setCurrentMaterials(newState.getCurrentMaterials()-newState.getMaterialsUseBUILD2());
        if(newState.getCurrentEnergy()<0 || newState.getCurrentFood()<0 || newState.getCurrentMaterials()<0)
            return null;
        newState.setCurrentFoodDelay(newState.getCurrentFoodDelay()-1);
        newState.setCurrentMaterialsDelay(newState.getCurrentMaterialsDelay()-1);
        newState.setCurrentEnergyDelay(newState.getCurrentEnergyDelay()-1);
        AI.Node newNode = new AI.Node(newState, input, Operator.BUILD_2, input.getDepth() + 1, MoneySpent, 0);
        return newNode;
    }
}
