package com.isaacp.DBFinal.constants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//class with constants to use in checking for acceptable values
public class AppConstants {
    public static final Set<String> accountStatuses = new HashSet<>(Arrays.asList("active", "inactive"));
    public static final Set<String> studentStatuses = new HashSet<>(Arrays.asList("active", "suspended", "expelled", "transferred", "alumni"));
    public static final Set<String> dormNames = new HashSet<>(Arrays.asList("mens", "womens"));
    public static final Set<String> staffStatuses = new HashSet<>(Arrays.asList("active", "terminated", "on leave", "retired"));
    public static final Set<String> studentTypes = new HashSet<>(Arrays.asList("dorm", "village"));
    public static final Set<String> leaveStatuses = new HashSet<>(Arrays.asList("approved", "denied", "pending"));

    //change all to individual variables and then do set of those variables
}
