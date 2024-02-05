# My App

This project is mostly a demonstration of tech stacks I'm familiar / fluent in, though a few bits are new when necessary.
I hadn't previously used Vaadin, but it's coming along easily enough.

## Vaadin: Front End
Being that I know java I stuck to that for the front end development so far. Vaadin is a bit outdated but I'm not
planning to do anything too fancy with it, so it should work just fine for me. It is a new thing to learn, so forgive me
while I experiment to figure it out.

## Spring:
I'm not entirely familiar with all the different things springs simplifies. I've been adding them as needed. I'll try
to keep an updated list
- Spring-Boot
- Spring-Data
- H2 database
- Flyway
- Lombok
- Vaadin-Integration
- Quartz
- JPA
- JDBC
- RestApi
- Maven
- Mockito (Not yet implemented)

# Plans
I'd like to just get some simple objects stored in a database that make sense to have relationships
- Person: should probably implement parents and family lines, as upline / downline is a common ask
- House: add houses and associate people with them
- Quartz: slow down how often new people are added finish the messaging tutorial and implement a day / night cycle?
- Vaadin: finish up the Push/subscribe tutorials so the front end updates when new people are added to the database
- Person and House will need views and the navigation should come from clicking on them. 
- Jobs/Roles: add some kind of roles Farmer/Builder/etc for the persons to perform as needed... perhaps a message queue?


