package com.example.task04;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Logger {
    public enum Levels {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    private String name;
    private Levels level = Levels.DEBUG;
    private static ArrayList<Logger> loggers = new ArrayList<>();

    public Logger(String name) {
        this.name = name;
        loggers.add(this);
    }

    String getName(){
        return name;
    }

    public void setLevel(Levels level) {
        this.level = level;
    }

    public Levels getLevel() {
        return level;
    }

    public void debug(String message) {
        log(Levels.DEBUG, message);
    }

    public void debug(String messageFormat, Object... params) {
        log(Levels.DEBUG, messageFormat, params);
    }

    public void info(String message) {
        log(Levels.INFO, message);
    }

    public void info(String messageFormat, Object... params) {
        log(Levels.INFO, messageFormat, params);
    }

    public void warning(String message) {
        log(Levels.WARNING, message);
    }

    public void warning(String messageFormat, Object... params) {
        log(Levels.WARNING, messageFormat, params);
    }

    public void error(String message) {
        log(Levels.ERROR, message);
    }

    public void error(String messageFormat, Object... params) {
        log(Levels.ERROR, messageFormat, params);
    }

    private void log(Levels level, String message) {
        if (this.level.ordinal() > level.ordinal()) return;
        System.out.println(String.format("[%s] %s %s - %s", level.name(),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss")), name, message));
    }

    private void log(Levels level, String messageFormat, Object... params) {
        if (this.level.ordinal() > level.ordinal()) return;
        System.out.println(String.format(messageFormat, params));
    }

    public static Logger getLogger(String name){
        for (Logger logger: loggers) {
            if (logger.name.equals(name))
                return logger;
        }
        return new Logger(name);
    }
}