Entity List:
1. Force Type
  Attributes: Name, ID, Description
  Synonyms: Fist_Melee, Physical Takedown, GrabOrHold, Taser, Less_Lethal, Lethal
            Spike_Strips, PIT_Manuver, Ramming.
  Description: This entity modesl the type of force used by the officer and how it was used.

2. Police Officer
   Attrinutes: Name, ID, Rank, Department, Experience(Years)
   Synonyms: Patrol_Officer, SWAT, K9_Handler, Detective, Undercover.
   Description: This is the type of police officer.

3. Infractions
   Attributes: ID, Date, Officer, Force_Type, Suspect.
   Synonyms: Assault, Battery, Theift, Robbery, PennyTheft, GrandTheftAuto,
             Murder, CapitalMurder, etc.
   Description: This represents what law was broken by the suspect.

4. Suspect
   Attributes: Name, ID, Ethnicity, Home, Gender.
   Synonyms: None.
   Description: This is the suspect who the use of force was used upon.

Relationships:
1. Police Officer-Force Type
   Minumum: One-One
   Maximum: One-Many
2. Suspect-Infractions
   Minimum: One-One
   Maximum: One-Many
3. Police Officer-Force Type-Suspect
   Minimum: One-One-One
   Maximum: One-Many-Many
   
Attribute Max/Min:
1. ID
   Minimum: Required.
   Maximum: Unique.

2. Name
   Minimum: Required.
   Maximum: Singular.

3. Description
   Minimum: Optional.
   Maximum: Singular.

4. Department
   Minimum: Required.
   Maximum Singular.

5. Rank
   Minimum: Required.
   Maximum: Singular.

6. Experience
   Minimum: Required.
   Maximum: Singular.

7. Date
   Minimum: Required.
   Maximum: Singular.

8. Officer
   Minimum: Required.
   Maximum: Plural.

9. Force_Type
   Minimum: Required.
   Maximum: Singular.

10. Suspect
    Minimum: Required.
    Maxmimum: Plural.

11. Ethnicity
    Minimum: Required.
    Maximum: Singular.

12. Home
    Minimum: Optional.
    Maximum Singular.

13. Gender
    Minimum: Required.
    Maximum: Singular.
