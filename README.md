# Ri3d Code for FRC

### Description
The following code includes the code for a tank drive drivetrain, an elevator that lifts the arm up with the joystick, and a claw that works with pneumatics to extend the
claw arm, and to close and open it. The pneumatics will have 2 settings depending on the object picking up, cube and cone. There is also a slow mode for the drivetrain on the x key.

In total there are 6 motor controllers, 4 for the drivetrain, 2 for the elevator. We have a total of 4 solenoids, one for arm extension, 2 more for different settings
of the cube and cone, and one to retract the claw.

### Technical Challenges and the workarounds
1. Command base does not work with the template, had to work around by pasting code into time base template.
2. Logic erroring in elevator system, solved by rewriting it into right Y axis on controller.
3. Drivestation inverted controllers, had to invert them in code. (Unknown reason)
