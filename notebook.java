public class notebook {
    
    int RAM;
    int hardDisk;
    String opSystem;
    String color;
    String brand;
    String model;

   
    public notebook(String brand, String model, int RAM, int hardDisk, String opSystem, String color){

        this.brand = brand.toUpperCase();
        this.model = model.toUpperCase();
        this.RAM = RAM;
        this.hardDisk = hardDisk;
        this.opSystem = opSystem.toUpperCase();
        this.color = color.toLowerCase();

    }
   
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public void setHardDisk(int hardDisk) {
        this.hardDisk = hardDisk;
    }

    public void setopSystem(String opSystem) {
        this.opSystem = opSystem;
    }

    public void setColor(String color) {
        this.color = color;
    }
    


    
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getRAM() {
        return RAM;
    }

    public int getHardDisk() {
        return hardDisk;
    }

    public String getopSystem() {
        return opSystem;
    }

    public String getColor() {
        return color;
    }
    

    
    public void showInfo(){

        System.out.println(String.format("Производитель: %s\nМодель: %s\nОЗУ(Гб): %d\nОбъем жесткого диска(Гб): %d\nОС: %s\nЦвет: %s\n",
        this.brand, this.model, this.RAM, this.hardDisk, this.opSystem, this.color));
    }
    
    @Override
    public String toString() {
        return (String.format("Производитель: %s\nМодель: %s\nОЗУ(Гб): %d\nОбъем жесткого диска(Гб): %d\nОС: %s\nЦвет: %s\n"+"\n",
        this.brand, this.model, this.RAM, this.hardDisk, this.opSystem, this.color));
    }
}      