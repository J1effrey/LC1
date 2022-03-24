//Time:O(n)
//Space:O(n)
class Solution {
    Map<Integer, Employee> map = new HashMap<>();
    
    public int getImportance(List<Employee> employees, int id) {        
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }

        return getImportanceOfEmployee(id);
    }
    
    private int getImportanceOfEmployee(int id) {
        int total = 0;
        Employee cur = map.get(id);
        total += cur.importance;
        
        for (Integer otherId : cur.subordinates) {
            total += getImportanceOfEmployee(otherId);
        }
        
        return total;
    }
}
