package iterator_and_comparators.pet_clinics.models;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.function.Consumer;

public class Clinic implements Iterable<Pet>{
    private Pet[] rooms;
    private int size;
    private int used;
    private int centre;

    public Clinic(int count) {
        this.setRooms(count);
        this.size = count;
        this.used = 0;
        this.centre = size / 2;
    }

    public void setRooms(int count) {
        if (count % 2 == 0){
            throw new IllegalArgumentException("Invalid Operation!");
        }
        this.rooms = new Pet[count];
    }

    public boolean add (Pet pet){
        int currentRoom = centre;
        int step = 0;
        int stepsTaken = 0;
        boolean goLeft = true;

        while (this.rooms[currentRoom] != null && step <= this.rooms.length / 2){
            if (goLeft){
                currentRoom = this.centre - step;
            } else {
                currentRoom = this.centre + step;
            }

            goLeft = !goLeft;
            stepsTaken++;
            if (stepsTaken == 2){
                step++;
                stepsTaken = 0;
            }
        }

        if (this.rooms[currentRoom] == null){
            this.rooms[currentRoom] = pet;
            this.used++;
            return true;
        }

        return false;
    }

    public boolean release() {
        if (this.rooms[this.centre] != null) {
            this.rooms[this.centre] = null;
            this.used--;
            return true;
        } else if(this.size > 1) {
            int currentRoom = centre + 1;
            while (this.rooms[currentRoom] == null && currentRoom != centre) {
                currentRoom = ++currentRoom % this.rooms.length;
            }

            if (this.rooms[currentRoom] != null) {
                this.rooms[currentRoom] = null;
                this.used--;
                return true;
            }
        }
        return false;
    }

    public String print(){
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= this.size;i++){
            sb.append(this.print(i)).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public String print(int room){
        if(this.rooms[room - 1] == null){
            return "Room empty";
        }else{
            return this.rooms[room - 1].toString();
        }
    }

    public boolean hasEmptyRooms(){
        return this.used != this.size;
    }

    @Override
    public Iterator<Pet> iterator() {
        if(this.rooms.length == 0){
            return Collections.<Pet>emptyIterator();
        }

        return Arrays.stream(this.rooms).iterator();
    }

    @Override
    public void forEach(Consumer<? super Pet> action) {
        for (Pet pet : this.rooms){
            action.accept(pet);
        }
    }
}
