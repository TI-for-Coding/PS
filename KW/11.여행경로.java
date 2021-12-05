import java.util.*;

class Solution {

    private int ticketCount = 0;
    public String[] solution(String[][] tickets) {
        ticketCount = tickets.length;

        Map<String, List<Ticket>> ticketsMap = new HashMap<>();

        for (String[] ticket : tickets){
            ticketsMap.putIfAbsent(ticket[0], new ArrayList<>());
            ticketsMap.putIfAbsent(ticket[1], new ArrayList<>());
            ticketsMap.get(ticket[0]).add(new Ticket(ticket[1]));
        }

        for (String key : ticketsMap.keySet()) {
            ticketsMap.get(key).sort(Comparator.comparing(o -> o.node));
        }
        List<String> answer = new ArrayList<>();
        answer.add("ICN");
        dfs(ticketsMap, answer);
        return answer.toArray(String[]::new);
    }

    private boolean dfs(Map<String, List<Ticket>> ticketMap, List<String> route) {
        if(route.size() == ticketCount+1) return true;
        String currPosition = route.get(route.size()-1);

        for(Ticket ticket : ticketMap.get(currPosition)){
            if(!ticket.used){
                ticket.used = true;
                route.add(ticket.node);
                boolean result = dfs(ticketMap, route);
                if(result){
                    return true;
                }else{
                    ticket.used = false;
                    route.remove(route.size()-1);
                }
            }
        }
        return false;
    }
}


class Ticket{
    public String node;
    public boolean used;

    public Ticket(String node) {
        this.node = node;
        this.used = false;
    }
}
