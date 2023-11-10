package code;

public class LLAPSearch extends GenericSearch {

    public LLAPSearch(Problem problem, SearchStrategy searchStrategy) {
        super(problem, searchStrategy);
    }

    public static String solve(String initialState, String searchStrategy, boolean visualize){
            SearchStrategy strategy = SearchStrategy.valueOf(searchStrategy);
            //super.getProblem().setInitialState(parseInitialState(initialState));
            GenericSearch genericSearch=new GenericSearch(new Problem(parseInitialState(initialState)),strategy);
            genericSearch.setVisualize(visualize);
            Node goalNode=genericSearch.SolveGenericSearch();
            if(goalNode==null)
                    return "NOSOLUTION";
            long moneySpent=goalNode.getState().getMoneySoFar();
            int numExpandedNodes=genericSearch.getNumExpandedNodes();
            String plan=reconstruction(goalNode);
            String Visualization;
            if(visualize){
                    Visualization=reconstructionVisualization(goalNode);
                    System.out.println(Visualization);
            }
            return plan+";"+moneySpent+";"+numExpandedNodes;
    }
    private static String reconstruction(Node goal){
            if(goal==null)
                    return "";
            return reconstruction(goal.getParentNode())+","+goal.getOperator();
    }
        private static String reconstructionVisualization(Node goal){
                if(goal==null)
                        return "";
                return reconstruction(goal.getParentNode())+"\n"+"Operator: "+goal.getOperator()+","+goal.toString();
        }

    public static State parseInitialState(String initialState){
            String[] input = initialState.split(";");


            int initialProsperity = Integer.parseInt(input[0]);

            String initialResources=input[1];
            String[] initialResourcesArray=initialResources.split(",");
            int initialFood = Integer.parseInt(initialResourcesArray[0]);
            int initialMaterials = Integer.parseInt(initialResourcesArray[1]);
            int initialEnergy = Integer.parseInt(initialResourcesArray[2]);

            String unitPrices=input[2];
            String[] unitPricesArray=unitPrices.split(",");
            int unitPriceFood = Integer.parseInt(unitPricesArray[0]);
            int unitPriceMaterials = Integer.parseInt(unitPricesArray[1]);
            int unitPriceEnergy = Integer.parseInt(unitPricesArray[2]);

            String foodRequestAmountAndDelay=input[3];
            String[] foodRequestAmountAndDelayArray=foodRequestAmountAndDelay.split(",");
            int amountRequestFood = Integer.parseInt(foodRequestAmountAndDelayArray[0]);
            int delayRequestFood = Integer.parseInt(foodRequestAmountAndDelayArray[1]);

            String materialsRequestAmountAndDelay=input[4];
            String[] materialsRequestAmountAndDelayArray=materialsRequestAmountAndDelay.split(",");
            int amountRequestMaterials = Integer.parseInt(materialsRequestAmountAndDelayArray[0]);
            int delayRequestMaterials = Integer.parseInt(materialsRequestAmountAndDelayArray[1]);

            String energyRequestAmountAndDelay=input[5];
            String[] energyRequestAmountAndDelayArray=energyRequestAmountAndDelay.split(",");
            int amountRequestEnergy = Integer.parseInt(energyRequestAmountAndDelayArray[0]);
            int delayRequestEnergy = Integer.parseInt(energyRequestAmountAndDelayArray[1]);

            String build1Resources=input[6];
            String[] build1ResourcesArray=build1Resources.split(",");
            int priceBUILD1 = Integer.parseInt(build1ResourcesArray[0]);
            int foodUseBUILD1 = Integer.parseInt(build1ResourcesArray[1]);
            int materialsUseBUILD1 = Integer.parseInt(build1ResourcesArray[2]);
            int energyUseBUILD1 = Integer.parseInt(build1ResourcesArray[3]);
            int prosperityBUILD1 = Integer.parseInt(build1ResourcesArray[4]);

            String build2Resources=input[7];
            String[] build2ResourcesArray=build2Resources.split(",");
            int priceBUILD2 = Integer.parseInt(build2ResourcesArray[0]);
            int foodUseBUILD2 = Integer.parseInt(build2ResourcesArray[1]);
            int materialsUseBUILD2 = Integer.parseInt(build2ResourcesArray[2]);
            int energyUseBUILD2 = Integer.parseInt(build2ResourcesArray[3]);
            int prosperityBUILD2 = Integer.parseInt(build2ResourcesArray[4]);

            return new State(
                    initialProsperity,
                    initialFood,
                    initialMaterials,
                    initialEnergy,
                    unitPriceFood,
                    unitPriceMaterials,
                    unitPriceEnergy,
                    amountRequestFood,
                    delayRequestFood,
                    amountRequestMaterials,
                    delayRequestMaterials,
                    amountRequestEnergy,
                    delayRequestEnergy,
                    priceBUILD1,
                    foodUseBUILD1,
                    materialsUseBUILD1,
                    energyUseBUILD1,
                    prosperityBUILD1,
                    priceBUILD2,
                    foodUseBUILD2,
                    materialsUseBUILD2,
                    energyUseBUILD2,
                    prosperityBUILD2,
                    0,
                    0);
    }


    //returns number of expanded nodes, so don't forget to keep track of them



}

