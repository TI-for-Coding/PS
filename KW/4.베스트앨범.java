/*

최대한 Stream을 이용하려하였으나, Stream api에 미숙하여..
혹시 개선점을 발견하신다면, 말씀해주시면 감사하겠습니다.

현재, 스트림은 두번 생기고 있습니다.
1. 장르 내 재생횟수에 따른 줄세우기.
2. 장르별 재생횟수에 따른 줄세우기.

 */


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();

        List<MusicRecord> records = IntStream.range(0, genres.length)
                .mapToObj(idx -> new MusicRecord(idx, genres[idx], plays[idx]))
                .collect(Collectors.toList());

        Map<String, List<MusicRecord>> result =
                records.stream().collect(
                        Collectors.groupingBy(
                                MusicRecord::getGenre,
                                Collectors.mapping(
                                        Function.identity(),
                                        Collectors.collectingAndThen(
                                                Collectors.toList(),
                                                musicRecords -> musicRecords.stream().sorted().limit(2).collect(Collectors.toList())
                                        )

                                )
                        )
                );
        List<Map.Entry<String, Integer>> sortedGenre = records.stream().collect(Collectors.groupingBy(MusicRecord::getGenre, Collectors.summingInt(MusicRecord::getCount)))
                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());

        sortedGenre.forEach(entry -> {
            answer.addAll(result.get(entry.getKey()).stream().map(MusicRecord::getIndex).collect(Collectors.toList()));
        });

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}


class MusicRecord implements Comparable<MusicRecord>{
    private final int index;
    private final String genre;
    private final int count;

    MusicRecord(int index, String genre, int count) {
        this.index = index;
        this.genre = genre;
        this.count = count;
    }

    public int getIndex() {
        return index;
    }

    public String getGenre() {
        return genre;
    }

    public int getCount() {
        return count;
    }

    @Override
    public int compareTo(MusicRecord o) {
        if(this.count > o.count) return -1;
        else if(this.count == o.count) {
            return Integer.compare(this.index, o.index);
        }else return 1;
    }

}