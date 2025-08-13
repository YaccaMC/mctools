package me.yaccamc.mctools.api;

@FunctionalInterface
public interface Catcher {
    RuntimeException catches(Exception e);
}
