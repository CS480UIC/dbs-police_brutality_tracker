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
   Attributes: Name, ID, Ethnicity, Home.
   Synonyms: None.
   Description: This is the suspect who the use of force was used upon.
