# User Administration

The User Administration subdomain focuses on managing users. It includes data classes for **User**, **Agent**, **Pharmacist** and **Administrator** information which follow the same class hierarchy found in the Initial Requirements document. It also includes the daemon service **UserRegistry** which runs on an administration server and keeps track of the list of registered users. It stores this list on-disk to persist the information, and does so redundantly for data integrity reasons. UserRegistry provides supporting functionality for the various user-related application commands. 

*N.B.: UserRegistry could serve as an adaptor to an on-disk SQLite Database, minimizing the risk of data loss and enabling the solution to be even more generic.*
