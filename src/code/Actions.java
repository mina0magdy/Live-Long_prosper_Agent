package code;

public class Actions {
   // in any action return null if it can't be performed according to the rules
    public static State copy(State currentState){
        State newState = new State(
                currentState.getCurrentProsperity(),
                currentState.getCurrentFood(),
                currentState.getCurrentMaterials(),
                currentState.getCurrentEnergy(),
                currentState.getUnitPriceFood(),
                currentState.getUnitPriceMaterials(),
                currentState.getUnitPriceEnergy(),
                currentState.getAmountRequestFood(),
                currentState.getDelayRequestFood(),
                currentState.getAmountRequestMaterials(),
                currentState.getDelayRequestMaterials(),
                currentState.getAmountRequestEnergy(),
                currentState.getDelayRequestEnergy(),
                currentState.getPriceBUILD1(),
                currentState.getFoodUseBUILD1(),
                currentState.getMaterialsUseBUILD1(),
                currentState.getEnergyUseBUILD1(),
                currentState.getProsperityBUILD1(),
                currentState.getPriceBUILD2(),
                currentState.getFoodUseBUILD2(),
                currentState.getMaterialsUseBUILD2(),
                currentState.getEnergyUseBUILD2(),
                currentState.getProsperityBUILD2(),
                currentState.getMoneySoFar(),
                currentState.getCurrentFoodDelay(),
                currentState.getCurrentMaterialsDelay(),
                currentState.getCurrentEnergyDelay()
        );
        return(newState);
    }
    public static Node requestFood(Node input, boolean visualize) {
        if(input.getState().getCurrentFoodDelay()!=0 || input.getState().getCurrentEnergyDelay()!=0 || input.getState().getCurrentMaterialsDelay()!=0) {
            return null;
        }
        State newState = copy(input.getState());
        int MoneySpent=newState.getUnitPriceEnergy()+newState.getUnitPriceFood()+newState.getUnitPriceMaterials();
        newState.setMoneySoFar(newState.getMoneySoFar()+MoneySpent);
        if(newState.getMoneySoFar()>100000) {
            return null;
        }
        newState.setCurrentEnergy(newState.getCurrentEnergy()-1);
        newState.setCurrentFood(newState.getCurrentFood()-1);
        newState.setCurrentMaterials(newState.getCurrentMaterials()-1);
        if(newState.getCurrentEnergy()<0 || newState.getCurrentFood()<0 || newState.getCurrentMaterials()<0) {
            return null;
        }
        newState.setCurrentFoodDelay(newState.getDelayRequestFood());

        int prosperityGainBuild1=newState.getProsperityBUILD1();
        int prosperityGainBuild2=newState.getProsperityBUILD2();
        int totalSpentBuild1=newState.getPriceBUILD1()+newState.getMaterialsUseBUILD1()+newState.getFoodUseBUILD1()+newState.getEnergyUseBUILD1();
        int totalSpentBuild2=newState.getPriceBUILD2()+newState.getMaterialsUseBUILD2()+newState.getFoodUseBUILD2()+newState.getEnergyUseBUILD2();
        int minCostPerProsperityLevel=Math.min(prosperityGainBuild1/totalSpentBuild1,prosperityGainBuild2/totalSpentBuild2);
        int maxGainBuild=Math.max(prosperityGainBuild1,prosperityGainBuild2);
        int currentProsperityLevel=newState.getCurrentProsperity();
        code.Node newNode = new code.Node(
                newState,
                input,
                Operator.RequestFood,
                input.getDepth() + 1,
                newState.getMoneySoFar(),
                (100-currentProsperityLevel)/maxGainBuild,
                (100-currentProsperityLevel)*minCostPerProsperityLevel);
        return newNode;
    }
    public static Node requestMaterials(Node input,boolean visualize) {
        if(input.getState().getCurrentFoodDelay()!=0 || input.getState().getCurrentEnergyDelay()!=0 || input.getState().getCurrentMaterialsDelay()!=0)
            return null;
        State newState = copy(input.getState());
        int MoneySpent=newState.getUnitPriceEnergy()+newState.getUnitPriceFood()+newState.getUnitPriceMaterials();
        newState.setMoneySoFar(newState.getMoneySoFar()+MoneySpent);
        if(newState.getMoneySoFar()>100000)
            return null;
        newState.setCurrentEnergy(newState.getCurrentEnergy()-1);
        newState.setCurrentFood(newState.getCurrentFood()-1);
        newState.setCurrentMaterials(newState.getCurrentMaterials()-1);
        if(newState.getCurrentEnergy()<0 || newState.getCurrentFood()<0 || newState.getCurrentMaterials()<0)
            return null;
        newState.setCurrentMaterialsDelay(newState.getDelayRequestMaterials());
        int prosperityGainBuild1=newState.getProsperityBUILD1();
        int prosperityGainBuild2=newState.getProsperityBUILD2();
        int totalSpentBuild1=newState.getPriceBUILD1()+newState.getMaterialsUseBUILD1()+newState.getFoodUseBUILD1()+newState.getEnergyUseBUILD1();
        int totalSpentBuild2=newState.getPriceBUILD2()+newState.getMaterialsUseBUILD2()+newState.getFoodUseBUILD2()+newState.getEnergyUseBUILD2();
        int minCostPerProsperityLevel=Math.min(prosperityGainBuild1/totalSpentBuild1,prosperityGainBuild2/totalSpentBuild2);
        int maxGainBuild=Math.max(prosperityGainBuild1,prosperityGainBuild2);
        int currentProsperityLevel=newState.getCurrentProsperity();
        code.Node newNode = new code.Node(newState, input, Operator.RequestMaterials, input.getDepth() + 1, newState.getMoneySoFar(),
                (100-currentProsperityLevel)/maxGainBuild,
                (100-currentProsperityLevel)*minCostPerProsperityLevel);
        return newNode;
    }
    public static Node requestEnergy(Node input,boolean visualize) {
        if(input.getState().getCurrentFoodDelay()!=0 || input.getState().getCurrentEnergyDelay()!=0 || input.getState().getCurrentMaterialsDelay()!=0)
            return null;
        State newState = copy(input.getState());
        int MoneySpent=newState.getUnitPriceEnergy()+newState.getUnitPriceFood()+newState.getUnitPriceMaterials();
        newState.setMoneySoFar(newState.getMoneySoFar()+MoneySpent);
        if(newState.getMoneySoFar()>100000)
            return null;
        newState.setCurrentEnergy(newState.getCurrentEnergy()-1);
        newState.setCurrentFood(newState.getCurrentFood()-1);
        newState.setCurrentMaterials(newState.getCurrentMaterials()-1);
        if(newState.getCurrentEnergy()<0 || newState.getCurrentFood()<0 || newState.getCurrentMaterials()<0)
            return null;
        newState.setCurrentEnergyDelay(newState.getDelayRequestEnergy());

        int prosperityGainBuild1=newState.getProsperityBUILD1();
        int prosperityGainBuild2=newState.getProsperityBUILD2();
        int totalSpentBuild1=newState.getPriceBUILD1()+newState.getMaterialsUseBUILD1()+newState.getFoodUseBUILD1()+newState.getEnergyUseBUILD1();
        int totalSpentBuild2=newState.getPriceBUILD2()+newState.getMaterialsUseBUILD2()+newState.getFoodUseBUILD2()+newState.getEnergyUseBUILD2();
        int minCostPerProsperityLevel=Math.min(prosperityGainBuild1/totalSpentBuild1,prosperityGainBuild2/totalSpentBuild2);
        int maxGainBuild=Math.max(prosperityGainBuild1,prosperityGainBuild2);
        int currentProsperityLevel=newState.getCurrentProsperity();
        code.Node newNode = new code.Node(newState, input, Operator.RequestEnergy, input.getDepth() + 1, newState.getMoneySoFar(),
                (100-currentProsperityLevel)/maxGainBuild,
                (100-currentProsperityLevel)*minCostPerProsperityLevel);
        return newNode;
    }
    public static Node wait(Node input,boolean visualize) {
        State newState = copy(input.getState());
        if(newState.getCurrentFoodDelay()==0 && newState.getCurrentEnergyDelay()==0 && newState.getCurrentMaterialsDelay()==0)
            return null;
        int MoneySpent=newState.getUnitPriceEnergy()+newState.getUnitPriceFood()+newState.getUnitPriceMaterials();
        newState.setMoneySoFar(newState.getMoneySoFar()+MoneySpent);
        if(newState.getMoneySoFar()>100000)
            return null;
        newState.setCurrentFoodDelay(newState.getCurrentFoodDelay()-1);
        newState.setCurrentMaterialsDelay(newState.getCurrentMaterialsDelay()-1);
        newState.setCurrentEnergyDelay(newState.getCurrentEnergyDelay()-1);

        newState.setCurrentEnergy(newState.getCurrentEnergy()-1);
        newState.setCurrentFood(newState.getCurrentFood()-1);
        newState.setCurrentMaterials(newState.getCurrentMaterials()-1);
        if(newState.getCurrentEnergy()<0 || newState.getCurrentFood()<0 || newState.getCurrentMaterials()<0)
            return null;

        int prosperityGainBuild1=newState.getProsperityBUILD1();
        int prosperityGainBuild2=newState.getProsperityBUILD2();
        int totalSpentBuild1=newState.getPriceBUILD1()+newState.getMaterialsUseBUILD1()+newState.getFoodUseBUILD1()+newState.getEnergyUseBUILD1();
        int totalSpentBuild2=newState.getPriceBUILD2()+newState.getMaterialsUseBUILD2()+newState.getFoodUseBUILD2()+newState.getEnergyUseBUILD2();
        int minCostPerProsperityLevel=Math.min(prosperityGainBuild1/totalSpentBuild1,prosperityGainBuild2/totalSpentBuild2);
        int maxGainBuild=Math.max(prosperityGainBuild1,prosperityGainBuild2);
        int currentProsperityLevel=newState.getCurrentProsperity();

        code.Node newNode = new code.Node(newState, input, Operator.WAIT, input.getDepth() + 1, newState.getMoneySoFar(),
                (100-currentProsperityLevel)/maxGainBuild,
                (100-currentProsperityLevel)*minCostPerProsperityLevel);
        return newNode;
    }
    public static Node build1(Node input,boolean visualize) {
        State newState = copy(input.getState());
        int MoneySpentPerEnergy=newState.getEnergyUseBUILD1()* newState.getUnitPriceEnergy();
        int MoneySpentPerFood=newState.getFoodUseBUILD1()*newState.getUnitPriceFood();
        int MoneySpentPerMaterials=newState.getMaterialsUseBUILD1()*newState.getUnitPriceMaterials();
        int MoneySpent=newState.getPriceBUILD1()+MoneySpentPerEnergy+MoneySpentPerFood+MoneySpentPerMaterials;
        newState.setMoneySoFar(newState.getMoneySoFar()+MoneySpent);
        if(newState.getMoneySoFar()>100000){
            return null;
        }
        newState.setCurrentFoodDelay(newState.getCurrentFoodDelay()-1);
        newState.setCurrentMaterialsDelay(newState.getCurrentMaterialsDelay()-1);
        newState.setCurrentEnergyDelay(newState.getCurrentEnergyDelay()-1);

        newState.setCurrentProsperity(newState.getCurrentProsperity()+newState.getProsperityBUILD1());
        newState.setCurrentEnergy(newState.getCurrentEnergy()-newState.getEnergyUseBUILD1());
        newState.setCurrentFood(newState.getCurrentFood()-newState.getFoodUseBUILD1());
        newState.setCurrentMaterials(newState.getCurrentMaterials()-newState.getMaterialsUseBUILD1());

        if(newState.getCurrentEnergy()<0 || newState.getCurrentFood()<0 || newState.getCurrentMaterials()<0)
            return null;
        int prosperityGainBuild1=newState.getProsperityBUILD1();
        int prosperityGainBuild2=newState.getProsperityBUILD2();
        int totalSpentBuild1=newState.getPriceBUILD1()+newState.getMaterialsUseBUILD1()+newState.getFoodUseBUILD1()+newState.getEnergyUseBUILD1();
        int totalSpentBuild2=newState.getPriceBUILD2()+newState.getMaterialsUseBUILD2()+newState.getFoodUseBUILD2()+newState.getEnergyUseBUILD2();
        int minCostPerProsperityLevel=Math.min(prosperityGainBuild1/totalSpentBuild1,prosperityGainBuild2/totalSpentBuild2);
        int maxGainBuild=Math.max(prosperityGainBuild1,prosperityGainBuild2);
        int currentProsperityLevel=newState.getCurrentProsperity();
        code.Node newNode = new code.Node(newState, input, Operator.BUILD1, input.getDepth() + 1, newState.getMoneySoFar(),
                (100-currentProsperityLevel)/maxGainBuild,
                (100-currentProsperityLevel)*minCostPerProsperityLevel);
        return newNode;
    }
    public static Node build2(Node input,boolean visualize) {
        State newState = copy(input.getState());
        int MoneySpentPerEnergy=newState.getEnergyUseBUILD2()* newState.getUnitPriceEnergy();
        int MoneySpentPerFood=newState.getFoodUseBUILD2()*newState.getUnitPriceFood();
        int MoneySpentPerMaterials=newState.getMaterialsUseBUILD2()*newState.getUnitPriceMaterials();
        int MoneySpent=newState.getPriceBUILD2()+MoneySpentPerEnergy+MoneySpentPerFood+MoneySpentPerMaterials;
        newState.setMoneySoFar(newState.getMoneySoFar()+MoneySpent);
        if(newState.getMoneySoFar()>100000)
            return null;
        newState.setCurrentFoodDelay(newState.getCurrentFoodDelay()-1);
        newState.setCurrentMaterialsDelay(newState.getCurrentMaterialsDelay()-1);
        newState.setCurrentEnergyDelay(newState.getCurrentEnergyDelay()-1);

        newState.setCurrentProsperity(newState.getCurrentProsperity()+newState.getProsperityBUILD2());
        newState.setCurrentEnergy(newState.getCurrentEnergy()-newState.getEnergyUseBUILD2());
        newState.setCurrentFood(newState.getCurrentFood()-newState.getFoodUseBUILD2());
        newState.setCurrentMaterials(newState.getCurrentMaterials()-newState.getMaterialsUseBUILD2());

        if(newState.getCurrentEnergy()<0 || newState.getCurrentFood()<0 || newState.getCurrentMaterials()<0)
            return null;

        int prosperityGainBuild1=newState.getProsperityBUILD1();
        int prosperityGainBuild2=newState.getProsperityBUILD2();
        int totalSpentBuild1=newState.getPriceBUILD1()+newState.getMaterialsUseBUILD1()+newState.getFoodUseBUILD1()+newState.getEnergyUseBUILD1();
        int totalSpentBuild2=newState.getPriceBUILD2()+newState.getMaterialsUseBUILD2()+newState.getFoodUseBUILD2()+newState.getEnergyUseBUILD2();
        int minCostPerProsperityLevel=Math.min(prosperityGainBuild1/totalSpentBuild1,prosperityGainBuild2/totalSpentBuild2);
        int maxGainBuild=Math.max(prosperityGainBuild1,prosperityGainBuild2);
        int currentProsperityLevel=newState.getCurrentProsperity();
        code.Node newNode = new code.Node(newState, input, Operator.BUILD2, input.getDepth() + 1, newState.getMoneySoFar(),
                (100-currentProsperityLevel)/maxGainBuild,
                (100-currentProsperityLevel)*minCostPerProsperityLevel);
        return newNode;
    }
}
