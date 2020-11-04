public class apples {
    public static void main(String[] args){
        variety varietyObject = new varietyBuilder().setName("Delicious").setColor("Red").createVariety();
        varietyObject.saying();
    }
}

// variety class

class variety{
    private String name;
    private String color;

// constructor

    public variety(String name, String color){
        this.name = name;
        this.color = color;
    }


    public void setName(String name) {
        name = name;
    }

    public String getName() {
        return name;
    }

    public void saying(){
        System.out.printf("On sale today : %s\n", getName());
    }
}