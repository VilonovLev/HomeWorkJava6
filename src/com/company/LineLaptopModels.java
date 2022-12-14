package com.company;

import java.util.*;

public class LineLaptopModels {

    private int price;
    private int ram;
    private int hardDrive;
    private int diagonalScreen;

    private static TreeSet<LineLaptopModels> modelsSet = new TreeSet<>(new Comparator<LineLaptopModels>() {
        @Override
        public int compare(LineLaptopModels o1, LineLaptopModels o2) {
            return (o1.ram - o2.ram) - (o1.price - o2.price) -
                    (o1.hardDrive - o2.hardDrive) - (o1.diagonalScreen - o2.diagonalScreen);
        }
    });

    private LineLaptopModels(int price, int ram, int hardDrive, int diagonalScreen) {
        this.price = price;
        this.ram = ram;
        this.hardDrive = hardDrive;
        this.diagonalScreen = diagonalScreen;
    }

    public LineLaptopModels() {
    }

    public void addModelLaptop(int price, int ram, int hardDrive, int diagonalScreen) {
        LineLaptopModels newModel = new LineLaptopModels(price,ram, hardDrive, diagonalScreen);
        modelsSet.add(newModel);
    }

    @Override
    public String toString() {
        return "\nprice=" + price +
                ", Ram=" + ram +
                ", HardDrive=" + hardDrive +
                ", diagonalScreen=" + diagonalScreen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineLaptopModels that = (LineLaptopModels) o;
        return price == that.price &&
                ram == that.ram &&
                hardDrive == that.hardDrive &&
                diagonalScreen == that.diagonalScreen;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, ram, hardDrive, diagonalScreen);
    }

    public String searchModels() {
        System.out.println("Укажите минимальный характеристики:");
        HashMap<Integer, Integer> minMod = getSpecifications();
        System.out.println("Укажите максимальный характеристики:");
        HashMap<Integer, Integer> maxMod = getSpecifications();

        List<LineLaptopModels> resultList = new ArrayList<>();
        for (var model : modelsSet) {
            if ((model.price >= minMod.get(1) && model.price <= maxMod.get(1)) &&
                    (model.ram >= minMod.get(2) && model.ram <= maxMod.get(2)) &&
                    (model.hardDrive >= minMod.get(3) && model.hardDrive <= maxMod.get(3)) &&
                    (model.diagonalScreen >= minMod.get(4) && model.diagonalScreen <= maxMod.get(4))){
                resultList.add(model);
            }
        }
        if (resultList.size() > 0)
            return resultList.toString();
        else return "По вашему запросу ничего не найдено.";
    }

    private static HashMap<Integer, Integer> getSpecifications() {
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int i = 1;
        System.out.println("Укажите цену ($): ");
        resultMap.put(i++, scanner.nextInt());
        System.out.println("Укажите RAM (ГБ): ");
        resultMap.put(i++, scanner.nextInt());
        System.out.println("Укажите HD (ГБ): ");
        resultMap.put(i++, scanner.nextInt());
        System.out.println("Укажите диагональ (Inch): ");
        resultMap.put(i, scanner.nextInt());
        return resultMap;
    }

}
