package tyr.leet.code;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {

  public static void main(String[] args) {
    System.out.println(new Knapsack().knapsack(4, new Stuff[]{
        new Stuff(3, 2),
        new Stuff(4, 3),
        new Stuff(5, 4),
    }));
  }

  public Stuffs knapsack(int capacity, Stuff[] stuffs) {

    if (capacity <= 0) {
      return new Stuffs();
    }

    Stuffs[][] cache = new Stuffs[stuffs.length][capacity + 1];

    for (int i = stuffs.length - 1; i >= 0; i--) {
      for (int c = 0; c <= capacity; c++) {
        if (c == 0) {
          cache[i][c] = new Stuffs();
        } else {
          int remainCapacity = c - stuffs[i].weight;
          if (i == stuffs.length - 1) {
            if (remainCapacity >= 0) {
              cache[i][c] = new Stuffs(stuffs[i]);
            } else {
              cache[i][c] = new Stuffs();
            }
          } else {
            if (remainCapacity >= 0) {
              Stuffs withCurrent = cache[i + 1][remainCapacity].add(stuffs[i]);
              if (withCurrent.value() > cache[i + 1][c].value()) {
                cache[i][c] = withCurrent;
              } else {
                cache[i][c] = cache[i + 1][c];
              }
            } else {
              cache[i][c] = cache[i + 1][c];
            }
          }
        }

      }
    }

    return cache[0][capacity];
  }

  static class Stuffs {

    final List<Stuff> values;

    public Stuffs() {
      values = new ArrayList<>();
    }

    public Stuffs(Stuff stuff) {
      values = new ArrayList<>();
      values.add(stuff);
    }

    public Stuffs(List<Stuff> stuffs) {
      this.values = stuffs;
    }

    public Stuffs add(Stuff stuff) {
      List<Stuff> newList = new ArrayList<>(values.size() + 1);
      newList.add(stuff);
      newList.addAll(values);
      return new Stuffs(newList);
    }

    public int value() {
      int sum = 0;
      for (Stuff value : values) {
        sum += value.value;
      }
      return sum;
    }

    @Override
    public String toString() {
      return "Stuffs{" + values + '}';
    }
  }

  static class Stuff {
    final int value;
    final int weight;

    Stuff(int value, int weight) {
      this.weight = weight;
      this.value = value;
    }

    @Override
    public String toString() {
      return "Stuff{" +
          "value=" + value +
          ", weight=" + weight +
          '}';
    }
  }

}
