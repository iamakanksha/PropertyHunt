# Property Hunt Application

### Problem:
Aim is to build a console application for a property platform where users can register, list a property, and find properties matching their requirements.
You need to provide the following options:
Register, Login, and LogOut: 
- A user can sign up and login (No need for Authentication, the name can be considered as the id of the user). Login makes users active and logout makes them inactive.
- ListProperty: Users can list properties they are selling.
- Search: Users can search for listed properties (only available properties should appear in results). They can use a combination of:
Location (case insensitive exact match would suffice for search).
Price range.
ListingType: Sell/Rent
Size range.
The number of rooms: 1BHK, 2BHK, 3BHK.
Sort by: It could be price or size (only ascending order is required).
Users can choose any set of parameters above for search.
- Shortlist: Users can shortlist a property.
- ViewShortlisted: Users can view all the shortlisted properties (including sold but with the status should be “sold”).
- ViewListed: Users can view properties listed by them.
- MarkSold: Users can mark a property sold which was listed by them.
The range can be given as “X-Y” for X to Y inclusive or “X” for more than or equals to X)