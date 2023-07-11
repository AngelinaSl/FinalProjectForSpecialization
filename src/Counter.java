public class Counter {

    int count = 0;
    int tmp = 0;
    boolean bool = false;


    public int getCount() {
        return this.count;
    }

    public int setCount(int tmp) {
        this.count = tmp;
        return count;
    }

    public int addCount(Database database) {
        this.tmp = database.getLines();
//        System.out.println("Count = " + (count++));
        return this.tmp;

    }

    public boolean completedFields(String name, String dOB, String skills){
        if (name != "" & dOB != "" & skills != ""){
            return true;
        }
        return false;
    }


}
