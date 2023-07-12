public class Counter {

    int count = 0;
    int tmp = 0;

    public int setCount(int tmp) {
        this.count = tmp;
        return count;
    }

    public int addCount(Database database) {
        this.tmp = database.getLines();
        return this.tmp;
    }

    public boolean completedFields(String name, String dOB, String skills) {
        if (name != "" & dOB != "" & skills != "") {
            return true;
        }
        return false;
    }
}
