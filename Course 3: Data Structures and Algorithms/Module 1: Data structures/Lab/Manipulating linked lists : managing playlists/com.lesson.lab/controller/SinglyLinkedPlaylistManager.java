package com.lesson.lab.controller;

import com.lesson.lab.model.Song;

/**
 * The SinglyLinkedPlaylistManager class is responsible for managing a playlist of songs using a Singly linked list structure.
 * It provides methods to add, remove, and navigate through songs in the playlist.
 * This class supports checking for duplicate songs, moving to the next or previous song,
 * and displaying the current playlist.
 */
public class SinglyLinkedPlaylistManager {
    class Node {
        Song song; //Holds the data for each node, which in this case is a Song object.
        Node next; //A reference to the next node in the list, allowing traversal forward.

        Node(Song song) {
            this.song = song;
            this.next = null;
        }
    }
    private Node head;
    private Node current;

    public SinglyLinkedPlaylistManager() {
        head = null;
        current = null;
    }

    // Method to add a song to the playlist
    public void addFavoriteSong(Song newSong) {
        // TODO 1: check if the song already exists in the playlist
        // TODO 2: create a new node for the song
        // TODO 3: check if the playlist is empty
        //  If empty, set the new node as the head of the list, initialize the current node to the head.
        // TODO 4: if not empty, find the last node in the list
        //  Traverse the list to find the last node
        //TODO 5: set the next of the last node to the new node
        //print a confirmation message that the song was added

        if (isDuplicate(newSong)) {
            System.out.println("Song already exists in the playlist.");
            return;
        }

        Node newNode = new Node(newSong);
        if (head == null) {
            head = newNode;
            current = head;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }

        System.out.println(newSong.getTitle() + " added to the playlist.");
    }

    private boolean isDuplicate(Song song) {
        Node current = head;
        while (current != null) {
            if (current.song.getTitle().equals(song.getTitle()) && current.song.getArtist().equals(song.getArtist())) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Method to remove a song from the playlist based on the given index
    public void removeFavoriteSong(int index) {
        // TODO 6: Check if the index is less than 1. If so, print “Invalid index.” and return.
        // TODO 7: Check if the playlist is empty (head == null). If so, print “Playlist is empty.” and return.
        // TODO 8: If the index is 1, set head to head.next, print the title of the removed song, and return.
        // TODO 9: Traverse the playlist using a loop, keeping track of current, previous, and count.
        // TODO 10: If current is null after the loop, print “Invalid index.”
        // TODO 11: If a valid node is found, adjust previous.next to remove the current node and print the title of the removed song.
        if (index < 1) {
            System.out.println("Invalid index.");
            return;
        }

        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        if (index == 1) {
            System.out.println(head.song.getTitle() + " removed from the playlist.");
            head = head.next;
            return;
        }

        Node current = head;
        Node previous = null;
        int count = 1;

        while (current != null && count < index) {
            previous = current;
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Invalid index.");
        } else {
            System.out.println(current.song.getTitle() + " removed from the playlist.");
            previous.next = current.next;
        }

    }

    // Method to display all songs with index
    public void displayFavoriteSongs() {
        //TODO 12: check if the playlist is empty by verifying if head == null.
        // if empty, print “Playlist is empty.” and return.
        //TODO 13: initialize current to head and index to 1.
        //TODO 14: use a while loop to iterate through the playlist, printing each song’s index and details.
        //TODO 15: inside the loop, increment the index and update current to current.next.
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        Node current = head;
        int index = 1;
        while (current != null) {
            System.out.println(index + ". " + current.song);
            current = current.next;
            index++;
        }

    }

    // Method to play the next song in the playlist
    public void playNextFavoriteSong() {
        // TODO 16: check if there is no next song by verifying if current == null or current.next == null.
        // if so, print “No next song in the playlist.”
        // TODO 17: if there is a next song, update current to current.next.
        // TODO 18: print the details of the now playing song.
        if (current == null || current.next == null) {
            System.out.println("No next song in the playlist.");
        } else {
            current = current.next;
            System.out.println("Now playing: " + current.song);
        }
    }

    // Method to play the previous song in the playlist
    public void playPreviousFavoriteSong() {
        // Check if the playlist is empty or if the current song is the head
        // If `current` is `null` or `current` is pointing to `head`, there is no previous song to play.
        // If there is no previous song, print a message to the user
        // Initialize a temporary node `temp` to start from the head of the list
        // Traverse the list to find the node just before `current`
        // This involves iterating through the list until `temp.next` is `current`
        //Set `current` to `temp`, effectively moving back one song
        //Print the song details of the new `current` node
        if (current == null || current == head) {
            System.out.println("No previous song in the playlist.");
        } else {
            Node temp = head;
            while (temp.next != current) {
                temp = temp.next;
            }
            current = temp;
            System.out.println("Now playing: " + current.song);
        }
    }

    // Method to start playing from the first song in the playlist
    public void setCurrentToFirst() {
        current = head;
        if (current != null) {
            System.out.println("Now playing: " + current.song);
        } else {
            System.out.println("Playlist is empty.");
        }
    }

    // Check if playlist is empty
    public boolean isEmpty() {
        return head == null;
    }
}

