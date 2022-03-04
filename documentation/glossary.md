Entity List:
1. Force Type
  Attributes: Name (NOT NULL), ID (NOT NULL), Description (NULL)
  Synonyms: Fist_Melee, Physical Takedown, GrabOrHold, Taser, Less_Lethal, Lethal
            Spike_Strips, PIT_Manuver, Ramming.
  Description: This entity modesl the type of force used by the officer and how it was used.

2. Police_Officer
   Attrinutes: Name (NOT NULL), ID (NOT NULL), Rank (NOT NULL), Department (NOT NULL), Experience(Years) (NOT NULL)
   Synonyms: Patrol_Officer, SWAT, K9_Handler, Detective, Undercover.
   Description: This is the type of police officer.

3. Infractions
   Attributes: ID (NOT NULL), Date (NOT NULL), Officer (NOT NULL), Force_Type (NOT NULL), Suspect (NOT NULL).
   Synonyms: Assault, Battery, Theift, Robbery, PennyTheft, GrandTheftAuto,
             Murder, CapitalMurder, etc.
   Description: This represents what law was broken by the suspect.

4. Suspect
   Attributes: Name (NOT NULL), ID (NOT NULL), Ethnicity (NOT NULL), Home (NULL), Gender (NOT NULL).
   Synonyms: None.
   Description: This is the suspect who the use of force was used upon.

5. User_Login
   Attributes: Username (NOT NULL), Pasword (NOT NULL).
   Synonyms: None.
   Description: This is the user login data for the database.
   
Dependent Entities:

1. officer_involved
   Relationship: officer_id-officer_involved
   Rules/Actions: ON DELETE CASCADE, RESTRICT officer_id
2. force_type
   Relationship: force_id-force_type
   Rules/Actions: ON DELETE CASCADE, RESTRICT force_id
3. victim
   Relationship: victim_id-victim
   Rules/Actions: ON DELETE CASCADE, RESTRICT victim_id
4. rported_by
   Relationship: user_id-reported_by
   Rules/Actions: ON DELETE CASCADE, RESTRICT user_id
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
    
One Plural Attribute:
   One example of a plural atribute would be an officer.
There can be multiple police officers at a scene so there are
multiple officers for one suspect, or multiple suspects.
