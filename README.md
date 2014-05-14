Network Selection in Vertical Handover with AHP
==========================

A java implementation,in both command-line and Graphical User Interface Mode,
to rank the available networks during Vertical Handover using AHP(Analytic hierarchy process), based on user parameters.

AHP: http://en.wikipedia.org/wiki/Analytic_hierarchy_process

Vertical Handover: http://en.wikipedia.org/wiki/Vertical_handover

Procedure:

The user 1st specifies which quality of service class she would prefer. There are four classes - 
a) Conversational 
b) Streaming
c) Interactive
d) Background

More details here: http://www.umtsworld.com/technology/qos.htm

Next, the parameters of the available networks are obtained. In this project, it is also user-input, although 
in a real world scenario, it will be different.

The parameters include:

a) Access Network Type - This can contain the values from 1 to 4. 1 indicates Private Network, 2 indicates Private Network with guest access, 3 indicates Chargeable Public network, and 4 indicates Free public network. 

b) Roaming Partnership - This can contain the values from 1 to 5. 1 indicates that roaming partnership is with respect to scenario 1 of 3GPP 22.934. Similarly values  2, 3, 4, 5 indicates the roaming partnership with respect to scenario 2, scenario 3, scenario 4, and scenario 5 respectively.

c) Internet Connectivity Provided - This can contain the values between 1 and 2. 1 indicates that internet connectivity is not provided, and 2 indicates that internet connectivity is provided.

d) Cost/Byte - This value is directly present.

e) Security - This can again contain the values from 1 to 5. 1 indicated lowest security, and 5 indicates highest security.



