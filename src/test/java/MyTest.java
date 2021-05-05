import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MyTest {
    @Test
    public void test1ArraysWith4 (){
        int[] in = new int[] {1,2,3,4,5,6};
        int[] out = new int[] {5,6};
        Assertions.assertArrayEquals(out, Main.arrWith4(in));
    }

    @Test
    public void test2ArraysWith4 (){
        int[] in = new int[] {1,2,3,5,6};
        Assertions.assertThrows(RuntimeException.class, ()->{
            Main.arrWith4(in);
        });
    }

    @Test
    public void test1ArraysHas4And1 (){
        int[] in = new int[] {1,2,3,4,5,6};
        Assertions.assertFalse(Main.arraysHas4And1(in));
    }

    @Test
    public void test2ArraysHas4And1 (){
        int[] in = new int[] {1,1,1,4,4,4};
        Assertions.assertTrue(Main.arraysHas4And1(in));
    }

    @ParameterizedTest
    @MethodSource("listArrays")
    public void test3ArraysHas4And1(int[] in, int[] out){
        Assertions.assertArrayEquals(out, Main.arrWith4(in));
    }

    public static Stream<Arguments> listArrays (){
        List list = new ArrayList<>();
        list.add(Arguments.arguments(new int[]{1,2,4,5,6}, new int[]{5,6}));
        list.add(Arguments.arguments(new int[]{1,2,3,4}, new int[]{}));
        list.add(Arguments.arguments(new int[]{3,44,5,1,4,12,31}, new int[]{12,31}));
        list.add(Arguments.arguments(new int[]{1,2,3,4,5}, new int[]{5}));
        return list.stream();
    }
}
