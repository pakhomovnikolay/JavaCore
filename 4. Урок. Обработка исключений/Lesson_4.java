public class Lesson_4 {

    public static void main(String[] args) {
        
        /** Генерируем покупателей*/
        Shopper[] shoppers = ShopperFabric.generateShoppers(5);

        System.out.println("====================================== данные о сгенерированых сотрудниках ======================================");
        /** Выводим данные о сгенерированых сотрудниках */
        Integer i = 0;
        for (Shopper shopper : shoppers) {
            System.out.println(Integer.toString(i + 1) + ") " + shopper);
            i++;
        }
        System.out.println();

        congratulationsShoppers(shoppers);
        System.out.println();
    }


    private static void congratulationsShoppers(Shopper[] shoppers) {
        int count = 0;
        for (Shopper shopper : shoppers) {
            if (count % 3 == 0) {
                try {
                    shopper.congratulations(HolidaysEnum.NewYear);
                } catch (Exception e) {
                    System.out.println(e);
                }
                
            }
            else if (count % 3 == 1) {
                try {
                    shopper.congratulations(HolidaysEnum.February23);
                } catch (Exception e) {
                    System.out.println(e);
                }
                
            }
            else if (count % 3 == 2) {
                try {
                    shopper.congratulations(HolidaysEnum.March8);
                } catch (Exception e) {
                    System.out.println(e);
                }
                
            }
            count++;
        }
    }
}
