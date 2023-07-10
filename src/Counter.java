public class Counter {

    int count = 0;
    boolean bool = false;


    public int getCount() {
        return count;
    }

    public void addCount() {
        this.count++;
    }

    public boolean completedFields(String name, String dOB, String skills){
        if (name != "" & dOB != "" & skills != ""){
            return true;
        }
        return false;
    }

}
