import pygame
import random
from res import *


class Game:
    def __init__(self):
        pygame.init()
        self.gameOver = False
        self.clock = pygame.time.Clock()
        self.screen = pygame.display.set_mode((display_width, display_height))
        self.dim_screen = pygame.Surface(self.screen.get_size()).convert_alpha()
        self.dim_screen.fill((0, 0, 0, 180))
        
    
    
    
    def toss_screen(self):
        #global t,toss
        t = 1
        toss = "null"        
        tos = True
        click = pygame.mouse.get_pressed()
    
        bot = 0
        down = 0
        
        choose = "null"
    
        res = random.randint(0,10)
        
        #[x_coordinate,y_coordinate,width,height,color]
        b1 = [180,200,150,45,green] 
        b2 = [180,250,150,45,yellow]
        b3 = [300,350,150,45,blue]
        b4 = [50,350,150,45,red]
        
        while(tos):
            cur = pygame.mouse.get_pos()
            self.screen.fill(white)
            text = headfont.render("CHOOSE HEAD or TAIL", True, black)
            self.screen.blit(text, [10,50])
    
            
    
    #########################BUTTON 1################################
            
            if b1[2]+ b1[0] > cur[0] > b1[0] and b1[1] + b1[3] > cur[1] > b1[1]:
                b1[4] = light_green
                for event in pygame.event.get():
                    if event.type == pygame.MOUSEBUTTONDOWN and down == 0:
                        bot = 1
                        choose = "head"
                        if res%2==0:
                            toss = 'head'
    
                        else:
                            toss = 'tail'
            else:
                b1[4] = green
    
            pygame.draw.rect(self.screen, b1[4], (b1[0],b1[1],b1[2],b1[3]))
            text = medfont.render("HEADS", True, black)
            self.screen.blit(text, [190,210])
    
    ##########################BUTTON 2###############################
            
            if b2[2] + b2[0] > cur[0] > b2[0] and b2[1] + b2[3] > cur[1] > b2[1]:
                b2[4] = light_yellow
                for event in pygame.event.get():
                    if event.type == pygame.MOUSEBUTTONDOWN and down == 0:
                        bot = 1
                        choose = "tail"
                        if res%2==0:
                            toss = 'head'
    
                        else:
                            toss = 'tail'
                            
            else:
                b2[4] = yellow
    
            pygame.draw.rect(self.screen, b2[4], (b2[0],b2[1],b2[2],b2[3]))
            text = medfont.render("TAILS", True, black)
            self.screen.blit(text, [190,260])
    
    ##########################BUTTON 3###############################
            
            if b3[2] + b3[0] > cur[0] > b3[0] and b3[1] + b3[3] > cur[1] > b3[1]:
                b3[4] = light_blue
                for event in pygame.event.get():
                    if event.type == pygame.MOUSEBUTTONDOWN:
                        self.gameloop1p(t)
                        return
            else:
                b3[4] = blue
    
            pygame.draw.rect(self.screen, b3[4], (b3[0],b3[1],b3[2],b3[3]))
            text = medfont.render("OK", True, black)
            self.screen.blit(text, [310,360])
    
    ##################################################################
    
    ##########################BUTTON 4###############################
            
            if b4[2] + b4[0] > cur[0] > b4[0] and b4[1] + b4[3] > cur[1] > b4[1]:
                b4[4] = light_red
                for event in pygame.event.get():
                    if event.type == pygame.MOUSEBUTTONDOWN:
                        return
            else:
                b4[4] = red
    
            pygame.draw.rect(self.screen, b4[4], (b4[0],b4[1],b4[2],b4[3]))
            text = medfont.render("BACK", True, black)
            self.screen.blit(text, [60,360])
    
    ####################################################################
            
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    pygame.quit
                    quit()
                    
            if ((choose == toss) and bot==1):
                t = 0
                down = 1
                text = medfont.render("PLAYER 1 GOES FIRST!!", True, red)
                self.screen.blit(text, [80,450])
    
            elif((choose != toss) and bot==1):
                t = 1
                down = 1
                text = medfont.render("COMPUTER GOES FIRST!!", True, red)
                self.screen.blit(text, [80,450])        
    
            pygame.display.update()
    
    def game_over(self,winner):
        over = True
        click = pygame.mouse.get_pressed()
    
        #[x_coordinate,y_coordinate,width,height,color]
        b1 = [180,150,150,45,green]
        
        b2 = [180,250,150,45,yellow]
        
        while(over):
            cur = pygame.mouse.get_pos()
            text = headfont.render(winner+" Won the Game", True, reddish_pink)
            
            
            self.screen.blit(text, [0,50])
    #########################BUTTON 1################################
            
            if b1[2]+ b1[0] > cur[0] > b1[0] and b1[1] + b1[3] > cur[1] > b1[1]:
                b1[4] = light_green
                for event in pygame.event.get():
                    if event.type == pygame.MOUSEBUTTONDOWN:
                        self.game_intro()
            else:
                b1[4] = green
                
            pygame.draw.rect(self.screen, b1[4], (b1[0],b1[1],b1[2],b1[3]))
            text = medfont.render("Restart", True, black)
            self.screen.blit(text, [190,160])
    
            
    ##########################BUTTON 2###############################
            
            if b2[2] + b2[0] > cur[0] > b2[0] and b2[1] + b2[3] > cur[1] > b2[1]:
                b2[4] = light_yellow
                for event in pygame.event.get():
                    if event.type == pygame.MOUSEBUTTONDOWN:
                        pygame.quit()
                        quit()                        
                        
            else:
                b2[4] = yellow
    
            pygame.draw.rect(self.screen, b2[4], (b2[0],b2[1],b2[2],b2[3]))
            text = medfont.render("Quit", True, black)
            self.screen.blit(text, [190,260])
    
    ##################################################################
            
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    pygame.quit()
                    quit()
            pygame.display.update()    
        
    def game_intro(self):
        intro = True
        click = pygame.mouse.get_pressed()
        self.winner = "None"
    
        #[x_coordinate,y_coordinate,width,height,color]
        b1 = [180,150,150,45,green]
        
        b2 = [180,250,150,45,yellow]
        
        while(intro):
            cur = pygame.mouse.get_pos()
            self.screen.fill(white)
            text = largefont.render("TIC TAC TOE", True, black)
            self.screen.blit(text, [80,50])
    
    #########################BUTTON 1################################
            
            if b1[2]+ b1[0] > cur[0] > b1[0] and b1[1] + b1[3] > cur[1] > b1[1]:
                b1[4] = light_green
                for event in pygame.event.get():
                    if event.type == pygame.MOUSEBUTTONDOWN:
                        self.toss_screen()
            else:
                b1[4] = green
                
            pygame.draw.rect(self.screen, b1[4], (b1[0],b1[1],b1[2],b1[3]))
            text = medfont.render("1 PLAYER", True, black)
            self.screen.blit(text, [190,160])
    
            
    ##########################BUTTON 2###############################
            
            if b2[2] + b2[0] > cur[0] > b2[0] and b2[1] + b2[3] > cur[1] > b2[1]:
                b2[4] = light_yellow
                for event in pygame.event.get():
                    if event.type == pygame.MOUSEBUTTONDOWN:
                        self.gameloop()
            else:
                b2[4] = yellow
    
            pygame.draw.rect(self.screen, b2[4], (b2[0],b2[1],b2[2],b2[3]))
            text = medfont.render("2 PLAYER", True, black)
            self.screen.blit(text, [190,260])
    
    ##################################################################
            
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    pygame.quit()
                    quit()
            pygame.display.update()    
        
    def circle(self,current_O_x, current_O_y):
        pygame.draw.circle(self.screen, blue, (current_O_x, current_O_y),70)
        pygame.draw.circle(self.screen, white, (current_O_x, current_O_y),65)
        pygame.display.update()
    
    def cross(self,cx,cy):
        pygame.draw.line(self.screen, light_green, (cx,cy),(cx+60,cy+60), 10)
        pygame.draw.line(self.screen, light_green, (cx,cy),(cx+60,cy-60), 10)
        pygame.draw.line(self.screen, light_green, (cx,cy),(cx-60,cy-60), 10)
        pygame.draw.line(self.screen, light_green, (cx,cy),(cx-60,cy+60), 10)
        pygame.display.update()
    
    def drawMap(self):
        board_width_vert = 10
        board_height_vert = display_height
        board_width_hori = display_width
        board_height_hori = 10
        
        self.screen.fill(white)
        pygame.draw.rect(self.screen, light_red, [int(display_width/3),0, board_width_vert, board_height_vert])
        pygame.draw.rect(self.screen, light_red, [(display_width-(int(display_width/3))),0, board_width_vert, board_height_vert])
        pygame.draw.rect(self.screen, light_red, [0, int(display_height/3), board_width_hori, board_height_hori])
        pygame.draw.rect(self.screen, light_red, [0, (display_height-(int(display_height/3))), board_width_hori, board_height_hori])
    
    
    def isFull(self, arr):
        for i in range(0,9):
            if arr[i] == 0:
                return False
        return True
        
        
    def gameloop1p(self,t):
        gameOver = False
    
        #Occupied places(avoid the zeroth index because counting starts from 1)
        occ = [0,0,0,
               0,0,0,
               0,0,0]        
    
        pw = [0,
               0,0,0,
               0,0,0,
               0,0,0]
    
        board_width_vert = 10
        board_height_vert = display_height
        board_width_hori = display_width
        board_height_hori = 10
        
        #cross position
        topLeftX = display_width/6;
        topLeftY = display_height/6;
    
        #DRAWING THE PLAYING BOARD
        self.drawMap()
    
        #CHOOSING WHO GOSE FIRST
    
        if t == 1:
            baari = 1
        else:
            baari = 0
    
        win = 0
    
        #MAIN GAME LOOP
        while not gameOver:
    
            cur = pygame.mouse.get_pos()
    
            for event in pygame.event.get(): #INPUT HANDLING
                if event.type == pygame.QUIT:
                    pygame.quit()
                    quit()
    
                if event.type == pygame.KEYDOWN:
                    if event.key == pygame.K_r:
                        self.toss_screen()
                    if event.key == pygame.K_q:
                        return
    
                if t == 0:    
                    if event.type == pygame.MOUSEBUTTONDOWN:   
                        if event.button == 1 and int(display_width/3) > cur[0] > 20 and int(display_height/3) > cur[1]:
                            if(occ[0] != 1):
                                t = 1
                                pw[1] = 4
                                print('top left')
                                occ[0] = 1
                                self.cross(int(display_width/3)-topLeftX,int(display_height/3)-topLeftY)
                            else:
                                print("invalid")
    
                        if event.button == 1 and int(display_width/3) < cur[0] < (display_width-(int(display_width/3))) and int(display_height/3) > cur[1]:
                            if(occ[1] != 1):
                                pw[2] = 4
                                t = 1
                                print('top mid')
                                occ[1] = 1
                                self.cross(int(display_width/3)+topLeftX+10,int(display_height/3)-topLeftY)
                            else:
                                print("invalid") 
    
    
                        if event.button == 1 and (display_width-(int(display_width/3))) < cur[0] < display_width and int(display_height/3) > cur[1]:
                            if(occ[2] != 1):
                                pw[3] = 4
                                t = 1
                                print('top right')
                                occ[2] = 1
                                self.cross(int(display_width/3)+topLeftX+205,int(display_height/3)-topLeftY)
                            else:
                                print("invalid") 
    
    
                        if event.button == 1 and int(display_width/3) > cur[0] > 20 and int(display_height/3) < cur[1] < (display_height-(int(display_height/3))):
                            if(occ[3] != 1):
                                pw[4] = 4
                                t = 1
                                print('mid left')
                                occ[3] = 1
                                self.cross(int(display_width/3)-topLeftX,int(display_height/3)+topLeftY)
                            else:
                                print("invalid") 
    
    
                        if event.button == 1 and int(display_width/3) < cur[0] < (display_width-(int(display_width/3))) and int(display_height/3) < cur[1] < (display_height-(int(display_height/3))):
                            if(occ[4] != 1):
                                pw[5] = 4
                                t = 1
                                print('mid mid')
                                occ[4] = 1
                                self.cross(int(display_width/3)+topLeftX+10,int(display_height/3)+topLeftY)
                            else:
                                print("invalid")
    
    
                        if event.button == 1 and (display_width-(int(display_width/3))) < cur[0] < display_width and int(display_height/3) < cur[1] < (display_height-(int(display_height/3))):
                            if(occ[5] != 1):
                                pw[6] = 4
                                t = 1
                                print('mid right')
                                occ[5] = 1
                                self.cross(int(display_width/3)+topLeftX+205,int(display_height/3)+topLeftY)
                            else:
                                print("invalid")
    
                        if event.button == 1 and int(display_width/3) > cur[0] > 20 and (display_height-(int(display_height/3))) < cur[1] < display_height:
                            if(occ[6] != 1):
                                pw[7] = 4
                                t = 1
                                print('bottom left ')
                                occ[6] = 1
                                self.cross(int(display_width/3)-topLeftX,int(display_height/3)+topLeftY+205)
                            else:
                                print("invalid")
    
    
                        if event.button == 1 and int(display_width/3) < cur[0] < (display_width-(int(display_width/3))) and int(display_height-(int(display_height/3))) < cur[1] < display_height:
                            if(occ[7] != 1):
                                pw[8] = 4
                                t = 1
                                print('bottom mid')
                                occ[7] = 1
                                self.cross(int(display_width/3)+topLeftX+10,int(display_height/3)+topLeftY+205)
                            else:
                                print("invalid")
    
    
                        if event.button == 1 and (display_width-(int(display_width/3))) < cur[0] < display_width and int(display_height-(int(display_height/3))) < cur[1] < display_height:
                            if(occ[8] != 1):
                                t = 1
                                pw[9] = 4
                                print('bottom right')
                                occ[8] = 1
                                self.cross(int(display_width/3)+topLeftX+205,int(display_height/3)+topLeftY+205)
                            else:
                                print("invalid")
    
    
    
            if(t == 1 and baari==1):
                #########################################################################################################################
                #########################################################################################################################
                                                    #WHEN COMPUTER GOES FIRST#
                #########################################################################################################################
                #########################################################################################################################
                if(occ[0]==0 and occ[1]==0 and occ[2]==0 and occ[3]==0 and occ[4]==0 and occ[5]==0 and occ[6]==0 and occ[7]==0 and occ[8]==0):
                    t = 0
                    pw[1] = 1
                    print('top left')
                    occ[0] = 1
                    self.circle(int(display_width/3)-topLeftX,int(display_height/3)-topLeftY)
    
                ############################################################################
                ############################################################################
    
                elif(((pw[1]+pw[2]==2 or pw[6]+pw[9]==2) or pw[5]+pw[7]==2) and occ[2]==0):
                    pw[3] = 1
                    t = 0
                    print('top right')
                    occ[2] = 1
                    self.circle(int(display_width/3)+topLeftX+205,int(display_height/3)-topLeftY)
    
                elif((pw[1]+pw[3]==2 or pw[5]+pw[8]==2) and occ[1]==0):
                    pw[2] = 1
                    t = 0
                    print('top mid')
                    occ[1] = 1
                    self.circle(int(display_width/3)+topLeftX+10,int(display_height/3)-topLeftY)
    
                elif(((pw[2]+pw[3]==2 or pw[5]+pw[9]==2) or pw[4]+pw[7]==2) and occ[0]==0):
                    t = 0
                    pw[1] = 1
                    print('top left')
                    occ[0] = 1
                    self.circle(int(display_width/3)-topLeftX,int(display_height/3)-topLeftY)
    
                ############################################################################
    
                elif((pw[4]+pw[5]==2 or pw[3]+pw[9]==2) and occ[5]==0):
                    pw[6] = 1
                    t = 0
                    print('mid right')
                    occ[5] = 1
                    self.circle(int(display_width/3)+topLeftX+205,int(display_height/3)+topLeftY)
    
                elif(((pw[4]+pw[6]==2 or pw[2]+pw[8]==2) or (pw[3]+pw[7]==2 or pw[1]+pw[9]==2)) and occ[4]==0):
                    pw[5] = 1
                    t = 0
                    print('mid mid')
                    occ[4] = 1
                    self.circle(int(display_width/3)+topLeftX+10,int(display_height/3)+topLeftY)
    
                elif((pw[1]+pw[7]==2 or pw[5]+pw[6]==2) and occ[3]==0):
                    pw[4] = 1
                    t = 0
                    print('mid left')
                    occ[3] = 1
                    self.circle(int(display_width/3)-topLeftX,int(display_height/3)+topLeftY)
    
                ##############################################################################
    
                elif(((pw[1]+pw[4]==2 or pw[3]+pw[5]==2) or pw[8]+pw[9]==2) and occ[6]==0):
                    pw[7] = 1
                    t = 0
                    print('bottom left')
                    occ[6] = 1
                    self.circle(int(display_width/3)-topLeftX,int(display_height/3)+topLeftY+205)
    
                elif((pw[2]+pw[5]==2 or pw[7]+pw[9]==2) and occ[7]==0):
                    pw[8] = 1
                    t = 0
                    print('bottom mid')
                    occ[7] = 1
                    self.circle(int(display_width/3)+topLeftX+10,int(display_height/3)+topLeftY+205)
    
                elif(((pw[1]+pw[5]==2 or pw[3]+pw[6]==2) or pw[7]+pw[8]==2) and occ[8]==0):
                    t = 0
                    pw[9] = 1
                    print('bottom right')
                    occ[8] = 1
                    self.circle(int(display_width/3)+topLeftX+205,int(display_height/3)+topLeftY+205)
    
                ############################################################################
                ############################################################################
    
    
                elif(((pw[1]+pw[2]==8 or pw[6]+pw[9]==8) or pw[5]+pw[7]==8) and occ[2]==0):
                    pw[3] = 1
                    t = 0
                    print('top right')
                    occ[2] = 1
                    self.circle(int(display_width/3)+topLeftX+205,int(display_height/3)-topLeftY)
    
                elif((pw[1]+pw[3]==8 or pw[5]+pw[8]==8) and occ[1]==0):
                    pw[2] = 1
                    t = 0
                    print('top mid')
                    occ[1] = 1
                    self.circle(int(display_width/3)+topLeftX+10,int(display_height/3)-topLeftY)
    
                elif(((pw[2]+pw[3]==8 or pw[5]+pw[9]==8) or pw[4]+pw[7]==8) and occ[0]==0):
                    t = 0
                    pw[1] = 1
                    print('top left')
                    occ[0] = 1
                    self.circle(int(display_width/3)-topLeftX,int(display_height/3)-topLeftY)
    
                ############################################################################
    
                elif((pw[4]+pw[5]==8 or pw[3]+pw[9]==8) and occ[5]==0):
                    pw[6] = 1
                    t = 0
                    print('mid right')
                    occ[5] = 1
                    self.circle(int(display_width/3)+topLeftX+205,int(display_height/3)+topLeftY)
    
                elif(((pw[4]+pw[6]==8 or pw[2]+pw[8]==8) or (pw[3]+pw[7]==8 or pw[1]+pw[9]==8)) and occ[4]==0):
                    pw[5] = 1
                    t = 0
                    print('mid mid')
                    occ[4] = 1
                    self.circle(int(display_width/3)+topLeftX+10,int(display_height/3)+topLeftY)
    
                elif((pw[1]+pw[7]==8 or pw[5]+pw[6]==8) and occ[3]==0):
                    pw[4] = 1
                    t = 0
                    print('mid left')
                    occ[3] = 1
                    self.circle(int(display_width/3)-topLeftX,int(display_height/3)+topLeftY)
    
                ##############################################################################
    
                elif(((pw[1]+pw[4]==8 or pw[3]+pw[5]==8) or pw[8]+pw[9]==8) and occ[6]==1):
                    t = 0
                    pw[9] = 1
                    print('bottom right')
                    occ[8] = 1
                    self.circle(int(display_width/3)+topLeftX+205,int(display_height/3)+topLeftY+205)
    
                elif(((pw[1]+pw[4]==8 or pw[3]+pw[5]==8) or pw[8]+pw[9]==8) and occ[6]==0):
                    pw[7] = 1
                    t = 0
                    print('bottom left ')
                    occ[6] = 1
                    self.circle(int(display_width/3)-topLeftX,int(display_height/3)+topLeftY+205)
    
                elif((pw[2]+pw[5]==8 or pw[7]+pw[9]==8) and occ[7]==0):
                    pw[8] = 1
                    t = 0
                    print('bottom mid')
                    occ[7] = 1
                    self.circle(int(display_width/3)+topLeftX+10,int(display_height/3)+topLeftY+205)
    
                elif(((pw[1]+pw[5]==8 or pw[3]+pw[6]==8) or pw[7]+pw[8]==8) and occ[8]==0):
                    t = 0
                    pw[9] = 1
                    print('bottom right')
                    occ[8] = 1
                    self.circle(int(display_width/3)+topLeftX+205,int(display_height/3)+topLeftY+205)
    
                ############################################################################
                ############################################################################
    
                elif((occ[4]==1 and (pw[5]+0==4))  or  ((occ[2]==1 or occ[6]==1) and (pw[3]==4 or pw[7]==4))):
                    t = 0
                    pw[9] = 1
                    print('bottom right')
                    occ[8] = 1
                    self.circle(int(display_width/3)+topLeftX+205,int(display_height/3)+topLeftY+205)
    
                elif(((occ[8]==1 and  pw[9]==4) and (occ[3]==1 and pw[4]==4)) and (occ[2]!= 1 and pw[3]!=1)):#SPECIAL CASE 2: when player is in bottom right AND mid left
                    pw[3] = 1
                    t = 0
                    print('top right')
                    occ[2] = 1
                    self.circle(int(display_width/3)+topLeftX+205,int(display_height/3)-topLeftY)
    
                elif((occ[8]==1 and  pw[9]==4) and (occ[6]!= 1 and pw[7]!=1)):#SPECIAL CASE 1: when player is in bottom right ONLY
                    pw[7] = 1
                    t = 0
                    print('bottom left')
                    occ[6] = 1
                    self.circle(int(display_width/3)-topLeftX,int(display_height/3)+topLeftY+205)
                    
                elif(((occ[3]==1 and pw[4]==4) and (occ[1]==1 and pw[2]==4)) and (occ[4]!= 1 and pw[5]!=1)):#SPECIAL CASE 4: when player is in mid right AND top mid
                    pw[5] = 1
                    t = 0
                    print('mid mid')
                    occ[4] = 1
                    self.circle(int(display_width/3)+topLeftX+10,int(display_height/3)+topLeftY)
    
    
                elif(occ[3]==1 and pw[4]==4):#SPECIAL CASE 3: when player is in mid left ONLY
                    pw[3] = 1
                    t = 0
                    print('top right')
                    occ[2] = 1
                    self.circle(int(display_width/3)+topLeftX+205,int(display_height/3)-topLeftY)
    
                elif((occ[5]==1 and pw[6]==4) and (occ[1]==1 and pw[2]==4)):#SPECIAL CASE 6: when player is in mid right AND top mid
                    pw[5] = 1
                    t = 0
                    print('mid mid')
                    occ[4] = 1
                    self.circle(int(display_width/3)+topLeftX+10,int(display_height/3)+topLeftY)
    
    
                elif(occ[5]==1 and pw[6]==4):#SPECIAL CASE 5: when player is in mid right ONLY
                    pw[3] = 1
                    t = 0
                    print('top right')
                    occ[2] = 1
                    self.circle(int(display_width/3)+topLeftX+205,int(display_height/3)-topLeftY)
    
                elif((occ[1]==1 and pw[2]==4) and (occ[3]==1 and pw[4]==4)):#SPECIAL CASE 8: when player is in top mid AND mid left
                    pw[5] = 1
                    t = 0
                    print('mid mid')
                    occ[4] = 1
                    self.circle(int(display_width/3)+topLeftX+10,int(display_height/3)+topLeftY)
    
    
                elif(occ[1]==1 and pw[2]==4):#SPECIAL CASE 7: when player is in top mid ONLY
                    pw[7] = 1
                    t = 0
                    print('bottom left')
                    occ[6] = 1
                    self.circle(int(display_width/3)-topLeftX,int(display_height/3)+topLeftY+205)
    
                elif(occ[7]==1 and pw[8]==4):#SPECIAL CASE 9: when player is in bottom mid ONLY
                    pw[7] = 1
                    t = 0
                    print('bottom left')
                    occ[6] = 1
                    self.circle(int(display_width/3)-topLeftX,int(display_height/3)+topLeftY+205)
    
    
            elif(t==1 and baari==0):
                #########################################################################################################################
                #########################################################################################################################
                                                    #WHEN COMPUTER GOES SECOND#
                #########################################################################################################################
                #########################################################################################################################
    
                if(((pw[1]+pw[2]==2 or pw[6]+pw[9]==2) or pw[5]+pw[7]==2) and occ[2]==0):
                    pw[3] = 1
                    t = 0
                    print('top right')
                    occ[2] = 1
                    self.circle(int(display_width/3)+topLeftX+205,int(display_height/3)-topLeftY)
    
                elif((pw[1]+pw[3]==2 or pw[5]+pw[8]==2) and occ[1]==0):
                    pw[2] = 1
                    t = 0
                    print('top mid')
                    occ[1] = 1
                    self.circle(int(display_width/3)+topLeftX+10,int(display_height/3)-topLeftY)
    
                elif(((pw[2]+pw[3]==2 or pw[5]+pw[9]==2) or pw[4]+pw[7]==2) and occ[0]==0):
                    t = 0
                    pw[1] = 1
                    print('top left')
                    occ[0] = 1
                    self.circle(int(display_width/3)-topLeftX,int(display_height/3)-topLeftY)
    
                ############################################################################
    
                elif((pw[4]+pw[5]==2 or pw[3]+pw[9]==2) and occ[5]==0):
                    pw[6] = 1
                    t = 0
                    print('mid right')
                    occ[5] = 1
                    self.circle(int(display_width/3)+topLeftX+205,int(display_height/3)+topLeftY)
    
                elif(((pw[4]+pw[6]==2 or pw[2]+pw[8]==2) or (pw[3]+pw[7]==2 or pw[1]+pw[9]==2)) and occ[4]==0):
                    pw[5] = 1
                    t = 0
                    print('mid mid')
                    occ[4] = 1
                    self.circle(int(display_width/3)+topLeftX+10,int(display_height/3)+topLeftY)
    
                elif((pw[1]+pw[7]==2 or pw[5]+pw[6]==2) and occ[3]==0):
                    pw[4] = 1
                    t = 0
                    print('mid left')
                    occ[3] = 1
                    self.circle(int(display_width/3)-topLeftX,int(display_height/3)+topLeftY)
    
                ##############################################################################
    
                elif(((pw[1]+pw[4]==2 or pw[3]+pw[5]==2) or pw[8]+pw[9]==2) and occ[6]==0):
                    pw[7] = 1
                    t = 0
                    print('bottom left')
                    occ[6] = 1
                    self.circle(int(display_width/3)-topLeftX,int(display_height/3)+topLeftY+205)
    
                elif((pw[2]+pw[5]==2 or pw[7]+pw[9]==2) and occ[7]==0):
                    pw[8] = 1
                    t = 0
                    print('bottom mid')
                    occ[7] = 1
                    circle(int(display_width/3)+90,int(display_height/3)+250)
    
                elif(((pw[1]+pw[5]==2 or pw[3]+pw[6]==2) or pw[7]+pw[8]==2) and occ[8]==0):
                    t = 0
                    pw[9] = 1
                    print('bottom right')
                    occ[8] = 1
                    self.circle(int(display_width/3)+topLeftX+205,int(display_height/3)+topLeftY+205)
    
                ############################################################################
                ############################################################################
    
    
                elif(((pw[1]+pw[2]==8 or pw[6]+pw[9]==8) or pw[5]+pw[7]==8) and occ[2]==0):
                    pw[3] = 1
                    t = 0
                    print('top right')
                    occ[2] = 1
                    self.circle(int(display_width/3)+topLeftX+205,int(display_height/3)-topLeftY)
    
                elif((pw[1]+pw[3]==8 or pw[5]+pw[8]==8) and occ[1]==0):
                    pw[2] = 1
                    t = 0
                    print('top mid')
                    occ[1] = 1
                    self.circle(int(display_width/3)+topLeftX+10,int(display_height/3)-topLeftY)
    
                elif(((pw[2]+pw[3]==8 or pw[5]+pw[9]==8) or pw[4]+pw[7]==8) and occ[0]==0):
                    t = 0
                    pw[1] = 1
                    print('top left')
                    occ[0] = 1
                    self.circle(int(display_width/3)-topLeftX,int(display_height/3)-topLeftY)
    
                ############################################################################
    
                elif((pw[4]+pw[5]==8 or pw[3]+pw[9]==8) and occ[5]==0):
                    pw[6] = 1
                    t = 0
                    print('mid right')
                    occ[5] = 1
                    self.circle(int(display_width/3)+topLeftX+205,int(display_height/3)+topLeftY)
    
                elif(((pw[4]+pw[6]==8 or pw[2]+pw[8]==8) or (pw[3]+pw[7]==8 or pw[1]+pw[9]==8)) and occ[4]==0):
                    pw[5] = 1
                    t = 0
                    print('mid mid')
                    occ[4] = 1
                    self.circle(int(display_width/3)+topLeftX+10,int(display_height/3)+topLeftY)
    
                elif((pw[1]+pw[7]==8 or pw[5]+pw[6]==8) and occ[3]==0):
                    pw[4] = 1
                    t = 0
                    print('mid left')
                    occ[3] = 1
                    self.circle(int(display_width/3)-topLeftX,int(display_height/3)+topLeftY)
    
                ##############################################################################
    
    
                elif(((pw[1]+pw[4]==8 or pw[3]+pw[5]==8) or pw[8]+pw[9]==8) and occ[6]==0):
                    pw[7] = 1
                    t = 0
                    print('bottom left')
                    occ[6] = 1
                    self.circle(int(display_width/3)-topLeftX,int(display_height/3)+topLeftY+205)
    
                elif((pw[2]+pw[5]==8 or pw[7]+pw[9]==8) and occ[7]==0):
                    pw[8] = 1
                    t = 0
                    print('bottom mid')
                    occ[7] = 1
                    self.circle(int(display_width/3)+topLeftX+10,int(display_height/3)+topLeftY+205)
    
                elif(((pw[1]+pw[5]==8 or pw[3]+pw[6]==8) or pw[7]+pw[8]==8) and (occ[8]==0 and pw[9]!= 4)):
                    t = 0
                    pw[9] = 1
                    print('bottom right')
                    occ[8] = 1
                    self.circle(int(display_width/3)+topLeftX+205,int(display_height/3)+topLeftY+205)
    
                ############################################################################
                ############################################################################
    
                elif(((((occ[0]==1 and occ[8]==1) or (occ[2]==1 and occ[6]==1)) and ((pw[1]==4 and pw[9]==4) or (pw[3]==4 and pw[7]==4))) and (pw[8]!=4 or pw[8]==1)) and (occ[7]!=1 and pw[8]!=1)):
                    pw[8] = 1
                    t = 0
                    print('bottom mid ')
                    occ[7] = 1
                    self.circle(int(display_width/3)+topLeftX+10,int(display_height/3)+topLeftY+205)
    
                elif((((occ[4]==1 and pw[5]==4) and (occ[2]==1 and pw[3]==4)) and (pw[1]!=4)) and (occ[0]!=1 and pw[1]!=1)):
                    t = 0
                    pw[1] = 1
                    print('top left')
                    occ[0] = 1
                    self.circle(int(display_width/3)-topLeftX,int(display_height/3)-topLeftY)
    
                elif((occ[4]==1 and pw[5]==4) and (occ[6]!=1 and pw[7]!=1)):
                    pw[7] = 1
                    t = 0
                    print('bottom left')
                    occ[6] = 1
                    self.circle(int(display_width/3)-topLeftX,int(display_height/3)+topLeftY+205)
    
                elif(((occ[3]==1 and pw[4]==4) and (occ[1]==1 and pw[2]==4)) and (occ[0]!=1 and pw[1]!=1)):
                    t = 0
                    pw[1] = 1
                    print('top left')
                    occ[0] = 1
                    self.circle(int(display_width/3)-topLeftX,int(display_height/3)-topLeftY)
    
                elif(((occ[3]==1 and pw[4]==4) and (occ[7]==1 and pw[8]==4)) and (occ[6]!=1 and pw[7]!=1)):
                    pw[7] = 1
                    t = 0
                    print('bottom left')
                    occ[6] = 1
                    self.circle(int(display_width/3)-topLeftX,int(display_height/3)+topLeftY+205)
    
    
                elif(((occ[5]==1 and pw[6]==4) and (occ[1]==1 and pw[2]==4)) and (occ[2]!=1 and pw[3]!=1)):
                    pw[3] = 1
                    t = 0
                    print('top right')
                    occ[2] = 1
                    self.circle(int(display_width/3)+topLeftX+205,int(display_height/3)-topLeftY)
    
                elif(((occ[5]==1 and pw[6]==4) and (occ[7]==1 and pw[8]==4)) and (occ[8]!=1 and pw[9]!=1)):
                    t = 0
                    pw[9] = 1
                    print('bottom right')
                    occ[8] = 1
                    self.circle(int(display_width/3)+topLeftX+205,int(display_height/3)+topLeftY+205)
    
    
    
                elif(((occ[1]==1 and pw[2]==4) or (occ[3]==1 and pw[4]==4) or (occ[5]==1 and pw[6]==4) or (occ[7]==1 and pw[8]==4)) and (occ[4]!=1 and pw[5]!=1)):
                    pw[5] = 1
                    t = 0
                    print('mid mid')
                    occ[4] = 1
                    self.circle(int(display_width/3)+topLeftX+10,int(display_height/3)+topLeftY)
    
    
                elif((occ[0]==1 or occ[2]==1 or occ[6]==1 or occ[8]==1) and (occ[4]!=1 and pw[5]!=1)):
                    pw[5] = 1
                    t = 0
                    print('mid mid')
                    occ[4] = 1
                    self.circle(int(display_width/3)+topLeftX+10,int(display_height/3)+topLeftY)
    
                else:
                    if(occ[0]==0):
                        t = 0
                        pw[1] = 1
                        print('top left')
                        occ[0] = 1
                        self.circle(int(display_width/3)-topLeftX,int(display_height/3)-topLeftY)
    
                    elif(occ[1]==0):
                        pw[2] = 1
                        t = 0
                        print('top mid')
                        occ[1] = 1
                        self.circle(int(display_width/3)+topLeftX+10,int(display_height/3)-topLeftY)
    
                    elif(occ[2]==0):
                        pw[3] = 1
                        t = 0
                        print('top right')
                        occ[2] = 1
                        self.circle(int(display_width/3)+topLeftX+205,int(display_height/3)-topLeftY)
    
                    elif(occ[3]==0):
                        pw[4] = 1
                        t = 0
                        print('mid left')
                        occ[3] = 1
                        self.circle(int(display_width/3)-topLeftX,int(display_height/3)+topLeftY)
    
                    elif(occ[4]==0):
                        pw[5] = 1
                        t = 0
                        print('mid mid')
                        occ[4] = 1
                        self.circle(int(display_width/3)+topLeftX+10,int(display_height/3)+topLeftY)
    
                    elif(occ[5]==0):
                        pw[6] = 1
                        t = 0
                        print('mid right')
                        occ[5] = 1
                        self.circle(int(display_width/3)+topLeftX+205,int(display_height/3)+topLeftY)
    
                    elif(occ[6]==0):
                        pw[7] = 1
                        t = 0
                        print('bottom left')
                        occ[6] = 1
                        self.circle(int(display_width/3)-topLeftX,int(display_height/3)+topLeftY+205)
    
                    elif(occ[7]==0):
                        pw[8] = 1
                        t = 0
                        print('bottom mid')
                        occ[7] = 1
                        self.circle(int(display_width/3)+topLeftX+10,int(display_height/3)+topLeftY+205)
    
                    elif(occ[8]==0):
                        t = 0
                        pw[9] = 1
                        print('bottom right')
                        occ[8] = 1
                        self.circle(int(display_width/3)+topLeftX+205,int(display_height/3)+topLeftY+205)
    
    
            p1w1 = pw[1]+pw[2]+pw[3]
            p1w2 = pw[4]+pw[5]+pw[6]
            p1w3 = pw[7]+pw[8]+pw[9]
            p1w4 = pw[1]+pw[4]+pw[7]
            p1w5 = pw[2]+pw[5]+pw[8]
            p1w6 = pw[3]+pw[6]+pw[9]
            p1w7 = pw[1]+pw[5]+pw[9]
            p1w8 = pw[3]+pw[5]+pw[7]
    
            p2w1 = pw[1]+pw[2]+pw[3]
            p2w2 = pw[4]+pw[5]+pw[6]
            p2w3 = pw[7]+pw[8]+pw[9]
            p2w4 = pw[1]+pw[4]+pw[7]
            p2w5 = pw[2]+pw[5]+pw[8]
            p2w6 = pw[3]+pw[6]+pw[9]
            p2w7 = pw[1]+pw[5]+pw[9]
            p2w8 = pw[3]+pw[5]+pw[7]
    
            if((p1w1 == 12 or p1w2 == 12 or p1w3 == 12 or p1w4 == 12 or p1w5 == 12 or p1w6 == 12 or p1w7 == 12 or p1w8 == 12) and win==0):
                #print("PLAYER 1 IS THE WINNER")
                self.winner = "Player 1"
                if p1w1 == 12:
                    pygame.draw.rect(self.screen, light_yellow, [int(display_width/3)-topLeftX-50,int(display_height/3)-topLeftY-10, topLeftX*5, 20])
                    win=1
    
                if p1w2 == 12:
                    pygame.draw.rect(self.screen, light_yellow, [int(display_width/3)-topLeftX-50,int(display_height/3)+topLeftY-10, topLeftX*5, 20])
                    win=1
    
                if p1w3 == 12:
                    pygame.draw.rect(self.screen, light_yellow, [int(display_width/3)-topLeftX-50,int(display_height/3)+topLeftY+195, topLeftX*5, 20])
                    win=1
    
                if p1w4 == 12:
                    pygame.draw.rect(self.screen, light_yellow, [int(display_width/3)-topLeftX-10,int(display_height/3)-topLeftY-50, 20, topLeftY*5])
                    win=1
    
                if p1w5 == 12:
                    pygame.draw.rect(self.screen, light_yellow, [int(display_width/3)+topLeftX,int(display_height/3)-topLeftY-50, 20, topLeftY*5])
                    win=1
    
                if p1w6 == 12:
                    pygame.draw.rect(self.screen, light_yellow, [int(display_width/3)+topLeftX+195,int(display_height/3)-topLeftY-50, 20, topLeftY*5])
                    win=1
    
                if p1w7 == 12:
                    pygame.draw.line(self.screen, light_yellow, (int(display_width/3)-topLeftX,int(display_height/3)-topLeftY), (int(display_width/3)+topLeftX+205,int(display_height/3)+topLeftY+205), 20)
                    win=1
    
                if p1w8 == 12:
                    pygame.draw.line(self.screen, light_yellow, (int(display_width/3)+topLeftX+205,int(display_height/3)-topLeftY), (int(display_width/3)-topLeftX,int(display_height/3)+topLeftY+205), 20)
                    win=1
    
    
            elif((p2w1 == 3 or p2w2 == 3 or p2w3 == 3 or p2w4 == 3 or p2w5 == 3 or p2w6 == 3 or p2w7 == 3 or p2w8 == 3) and win==0):
                #print("PLAYER 2 IS THE WINNER")
                self.winner = "Computer"
                if p2w1 == 3:
                    pygame.draw.rect(self.screen, light_yellow, [int(display_width/3)-topLeftX-50,int(display_height/3)-topLeftY-10, topLeftX*5, 20])
                    win=1
    
                if p2w2 == 3:
                    pygame.draw.rect(self.screen, light_yellow, [int(display_width/3)-topLeftX-50,int(display_height/3)+topLeftY-10, topLeftX*5, 20])
                    win=1
    
                if p2w3 == 3:
                    pygame.draw.rect(self.screen, light_yellow, [int(display_width/3)-topLeftX-50,int(display_height/3)+topLeftY+195, topLeftX*5, 20])
                    win=1
    
                if p2w4 == 3:
                    pygame.draw.rect(self.screen, light_yellow, [int(display_width/3)-topLeftX-10,int(display_height/3)-topLeftY-50, 20, topLeftY*5])
                    win=1
    
                if p2w5 == 3:
                    pygame.draw.rect(self.screen, light_yellow, [int(display_width/3)+topLeftX,int(display_height/3)-topLeftY-50, 20, topLeftY*5])
                    win=1
    
                if p2w6 == 3:
                    pygame.draw.rect(self.screen, light_yellow, [int(display_width/3)+topLeftX+195,int(display_height/3)-topLeftY-50, 20, topLeftY*5])
                    win=1
    
                if p2w7 == 3:
                    pygame.draw.line(self.screen, light_yellow, (int(display_width/3)-topLeftX,int(display_height/3)-topLeftY), (int(display_width/3)+topLeftX+205,int(display_height/3)+topLeftY+205), 20)
                    win=1
    
                if p2w8 == 3:
                    pygame.draw.line(self.screen, light_yellow, (int(display_width/3)+topLeftX+205,int(display_height/3)-topLeftY), (int(display_width/3)-topLeftX,int(display_height/3)+topLeftY+205), 20)            
                    win=1
            
            
            if(win == 1 or self.isFull(occ)):
                self.screen.blit(self.dim_screen, (0, 0))
                self.game_over(self.winner)
                
                
            pygame.display.update()
            
        
    def gameloop(self):
    
        gameOver = False
    
        turn = 0
    
        occ = [0,0,0,
               0,0,0,
               0,0,0]
    
        pw = [0,
               0,0,0,
               0,0,0,
               0,0,0]
    
        win = 0
    
        board_width_vert = 10
        board_height_vert = display_height
        board_width_hori = display_width
        board_height_hori = 10
        
        #cross position
        topLeftX = display_width/6;
        topLeftY = display_height/6;
    
        #DRAWING THE PLAYING BOARD
        self.drawMap()
    
        while(not gameOver):
            cur = pygame.mouse.get_pos()
            click = pygame.mouse.get_pressed()
    
            if (turn%2) == 0:
                t = 1
            else:
                t = 0
    
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    pygame.quit()
                    quit()
                if event.type == pygame.KEYDOWN:
                    if event.key == pygame.K_r:
                        self.gameloop()
    
                    if event.key == pygame.K_q:
                        self.game_intro()
                if event.type == pygame.MOUSEBUTTONDOWN:
                    #self.cross DRAWING
                    if t==1: 
                        if event.button == 1 and int(display_width/3) > cur[0] > 20 and int(display_height/3) > cur[1]:
                            if(occ[0] != 1):
                                turn += 1
                                pw[1] = 4
                                print('top left')
                                occ[0] = 1
                                self.cross(int(display_width/3)-topLeftX,int(display_height/3)-topLeftY)
                            else:
                                print("invalid")
    
                        if event.button == 1 and int(display_width/3) < cur[0] < (display_width-(int(display_width/3))) and int(display_height/3) > cur[1]:
                            if(occ[1] != 1):
                                pw[2] = 4
                                turn += 1
                                print('top mid')
                                occ[1] = 1
                                self.cross(int(display_width/3)+topLeftX+10,int(display_height/3)-topLeftY)
                            else:
                                print("invalid") 
    
    
                        if event.button == 1 and (display_width-(int(display_width/3))) < cur[0] < display_width and int(display_height/3) > cur[1]:
                            if(occ[2] != 1):
                                pw[3] = 4
                                turn += 1
                                print('top right')
                                occ[2] = 1
                                self.cross(int(display_width/3)+topLeftX+205,int(display_height/3)-topLeftY)
                            else:
                                print("invalid") 
    
    
                        if event.button == 1 and int(display_width/3) > cur[0] > 20 and int(display_height/3) < cur[1] < (display_height-(int(display_height/3))):
                            if(occ[3] != 1):
                                pw[4] = 4
                                turn += 1
                                print('mid left')
                                occ[3] = 1
                                self.cross(int(display_width/3)-topLeftX,int(display_height/3)+topLeftY)
                            else:
                                print("invalid") 
    
    
                        if event.button == 1 and int(display_width/3) < cur[0] < (display_width-(int(display_width/3))) and int(display_height/3) < cur[1] < (display_height-(int(display_height/3))):
                            if(occ[4] != 1):
                                pw[5] = 4
                                turn += 1
                                print('mid mid')
                                occ[4] = 1
                                self.cross(int(display_width/3)+topLeftX+10,int(display_height/3)+topLeftY)
                            else:
                                print("invalid")
    
    
                        if event.button == 1 and (display_width-(int(display_width/3))) < cur[0] < display_width and int(display_height/3) < cur[1] < (display_height-(int(display_height/3))):
                            if(occ[5] != 1):
                                pw[6] = 4
                                turn += 1
                                print('mid right')
                                occ[5] = 1
                                self.cross(int(display_width/3)+topLeftX+205,int(display_height/3)+topLeftY)
                            else:
                                print("invalid")
    
                        if event.button == 1 and int(display_width/3) > cur[0] > 20 and (display_height-(int(display_height/3))) < cur[1] < display_height:
                            if(occ[6] != 1):
                                pw[7] = 4
                                turn += 1
                                print('bottom left')
                                occ[6] = 1
                                self.cross(int(display_width/3)-topLeftX,int(display_height/3)+topLeftY+205)
                            else:
                                print("invalid")
    
    
                        if event.button == 1 and int(display_width/3) < cur[0] < (display_width-(int(display_width/3))) and int(display_height-(int(display_height/3))) < cur[1] < display_height:
                            if(occ[7] != 1):
                                pw[8] = 4
                                turn += 1
                                print('bottom mid')
                                occ[7] = 1
                                self.cross(int(display_width/3)+topLeftX+10,int(display_height/3)+topLeftY+205)
                            else:
                                print("invalid")
    
    
                        if event.button == 1 and (display_width-(int(display_width/3))) < cur[0] < display_width and int(display_height-(int(display_height/3))) < cur[1] < display_height:
                            if(occ[8] != 1):
                                turn += 1
                                pw[9] = 4
                                print('bottom right')
                                occ[8] = 1
                                self.cross(int(display_width/3)+topLeftX+205,int(display_height/3)+topLeftY+205)
                            else:
                                print("invalid")
    
    
                    #self.self.circle DRAWING
                    else:
                        if event.button == 1 and int(display_width/3) > cur[0] > 20 and int(display_height/3) > cur[1]:
                            if(occ[0] != 1):
                                pw[1] = 1
                                turn += 1
                                print('top left')
                                occ[0] = 1
                                self.circle(int(display_width/3)-topLeftX,int(display_height/3)-topLeftY)
                            else:
                                print("invalid")
    
                        if event.button == 1 and int(display_width/3) < cur[0] < (display_width-(int(display_width/3))) and int(display_height/3) > cur[1]:
                            if(occ[1] != 1):
                                pw[2] = 1
                                turn += 1
                                print('top mid')
                                occ[1] = 1
                                self.circle(int(display_width/3)+topLeftX+10,int(display_height/3)-topLeftY)
                            else:
                                print("invalid") 
    
    
                        if event.button == 1 and (display_width-(int(display_width/3))) < cur[0] < display_width and int(display_height/3) > cur[1]:
                            if(occ[2] != 1):
                                pw[3] = 1
                                turn += 1
                                print('top right')
                                occ[2] = 1
                                self.circle(int(display_width/3)+topLeftX+205,int(display_height/3)-topLeftY)
                            else:
                                print("invalid") 
    
    
                        if event.button == 1 and int(display_width/3) > cur[0] > 20 and int(display_height/3) < cur[1] < (display_height-(int(display_height/3))):
                            if(occ[3] != 1):
                                pw[4] = 1
                                turn += 1
                                print('mid left')
                                occ[3] = 1
                                self.circle(int(display_width/3)-topLeftX,int(display_height/3)+topLeftY)
                            else:
                                print("invalid")
    
    
                        if event.button == 1 and int(display_width/3) < cur[0] < (display_width-(int(display_width/3))) and int(display_height/3) < cur[1] < (display_height-(int(display_height/3))):
                            if(occ[4] != 1):
                                pw[5] = 1
                                turn += 1
                                print('mid mid')
                                occ[4] = 1
                                self.circle(int(display_width/3)+topLeftX+10,int(display_height/3)+topLeftY)
                            else:
                                print("invalid")
    
    
                        if event.button == 1 and (display_width-(int(display_width/3))) < cur[0] < display_width and int(display_height/3) < cur[1] < (display_height-(int(display_height/3))):
                            if(occ[5] != 1):
                                pw[6] = 1
                                turn += 1
                                print('mid right')
                                occ[5] = 1
                                self.circle(int(display_width/3)+topLeftX+205,int(display_height/3)+topLeftY)
                            else:
                                print("invalid")
    
    
                        if event.button == 1 and int(display_width/3) > cur[0] > 20 and (display_height-(int(display_height/3))) < cur[1] < display_height:
                            if(occ[6] != 1):
                                pw[7] = 1
                                turn += 1
                                print('bottom left')
                                occ[6] = 1
                                self.circle(int(display_width/3)-topLeftX,int(display_height/3)+topLeftY+205)
                            else:
                                print("invalid")
    
    
                        if event.button == 1 and int(display_width/3) < cur[0] < (display_width-(int(display_width/3))) and int(display_height-(int(display_height/3))) < cur[1] < display_height:
                            if(occ[7] != 1):
                                pw[8] = 1
                                turn += 1
                                print('bottom mid')
                                occ[7] = 1
                                self.circle(int(display_width/3)+topLeftX+10,int(display_height/3)+topLeftY+205)
                            else:
                                print("invalid")
    
    
                        if event.button == 1 and (display_width-(int(display_width/3))) < cur[0] < display_width and int(display_height-(int(display_height/3))) < cur[1] < display_height:
                            if(occ[8] != 1):
                                turn += 1
                                pw[9] = 1
                                print('bottom right')
                                occ[8] = 1
                                self.circle(int(display_width/3)+topLeftX+205,int(display_height/3)+topLeftY+205)
                            else:
                                print("invalid")
    
            p1w1 = pw[1]+pw[2]+pw[3]
            p1w2 = pw[4]+pw[5]+pw[6]
            p1w3 = pw[7]+pw[8]+pw[9]
            p1w4 = pw[1]+pw[4]+pw[7]
            p1w5 = pw[2]+pw[5]+pw[8]
            p1w6 = pw[3]+pw[6]+pw[9]
            p1w7 = pw[1]+pw[5]+pw[9]
            p1w8 = pw[3]+pw[5]+pw[7]
    
            p2w1 = pw[1]+pw[2]+pw[3]
            p2w2 = pw[4]+pw[5]+pw[6]
            p2w3 = pw[7]+pw[8]+pw[9]
            p2w4 = pw[1]+pw[4]+pw[7]
            p2w5 = pw[2]+pw[5]+pw[8]
            p2w6 = pw[3]+pw[6]+pw[9]
            p2w7 = pw[1]+pw[5]+pw[9]
            p2w8 = pw[3]+pw[5]+pw[7]
    
            if((p1w1 == 12 or p1w2 == 12 or p1w3 == 12 or p1w4 == 12 or p1w5 == 12 or p1w6 == 12 or p1w7 == 12 or p1w8 == 12) and win==0):
                self.winner = "Player 1"
                if p1w1 == 12:
                    pygame.draw.rect(self.screen, light_yellow, [int(display_width/3)-topLeftX-50,int(display_height/3)-topLeftY-10, topLeftX*5, 20])
                    win=1
    
                if p1w2 == 12:
                    pygame.draw.rect(self.screen, light_yellow, [int(display_width/3)-topLeftX-50,int(display_height/3)+topLeftY-10, topLeftX*5, 20])
                    win=1
    
                if p1w3 == 12:
                    pygame.draw.rect(self.screen, light_yellow, [int(display_width/3)-topLeftX-50,int(display_height/3)+topLeftY+195, topLeftX*5, 20])
                    win=1
    
                if p1w4 == 12:
                    pygame.draw.rect(self.screen, light_yellow, [int(display_width/3)-topLeftX-10,int(display_height/3)-topLeftY-50, 20, topLeftY*5])
                    win=1
    
                if p1w5 == 12:
                    pygame.draw.rect(self.screen, light_yellow, [int(display_width/3)+topLeftX,int(display_height/3)-topLeftY-50, 20, topLeftY*5])
                    win=1
    
                if p1w6 == 12:
                    pygame.draw.rect(self.screen, light_yellow, [int(display_width/3)+topLeftX+195,int(display_height/3)-topLeftY-50, 20, topLeftY*5])
                    win=1
    
                if p1w7 == 12:
                    pygame.draw.line(self.screen, light_yellow, (int(display_width/3)-topLeftX,int(display_height/3)-topLeftY), (int(display_width/3)+topLeftX+205,int(display_height/3)+topLeftY+205), 20)
                    win=1
    
                if p1w8 == 12:
                    pygame.draw.line(self.screen, light_yellow, (int(display_width/3)+topLeftX+205,int(display_height/3)-topLeftY), (int(display_width/3)-topLeftX,int(display_height/3)+topLeftY+205), 20)
                    win=1
    
    
            elif((p2w1 == 3 or p2w2 == 3 or p2w3 == 3 or p2w4 == 3 or p2w5 == 3 or p2w6 == 3 or p2w7 == 3 or p2w8 == 3) and win==0):
                self.winner = "Player 2"
                if p2w1 == 3:
                    pygame.draw.rect(self.screen, light_yellow, [int(display_width/3)-topLeftX-50,int(display_height/3)-topLeftY-10, topLeftX*5, 20])
                    win=1
    
                if p2w2 == 3:
                    pygame.draw.rect(self.screen, light_yellow, [int(display_width/3)-topLeftX-50,int(display_height/3)+topLeftY-10, topLeftX*5, 20])
                    win=1
    
                if p2w3 == 3:
                    pygame.draw.rect(self.screen, light_yellow, [int(display_width/3)-topLeftX-50,int(display_height/3)+topLeftY+195, topLeftX*5, 20])
                    win=1
    
                if p2w4 == 3:
                    pygame.draw.rect(self.screen, light_yellow, [int(display_width/3)-topLeftX-10,int(display_height/3)-topLeftY-50, 20, topLeftY*5])
                    win=1
    
                if p2w5 == 3:
                    pygame.draw.rect(self.screen, light_yellow, [int(display_width/3)+topLeftX,int(display_height/3)-topLeftY-50, 20, topLeftY*5])
                    win=1
    
                if p2w6 == 3:
                    pygame.draw.rect(self.screen, light_yellow, [int(display_width/3)+topLeftX+195,int(display_height/3)-topLeftY-50, 20, topLeftY*5])
                    win=1
    
                if p2w7 == 3:
                    pygame.draw.line(self.screen, light_yellow, (int(display_width/3)-topLeftX,int(display_height/3)-topLeftY), (int(display_width/3)+topLeftX+205,int(display_height/3)+topLeftY+205), 20)
                    win=1
    
                if p2w8 == 3:
                    pygame.draw.line(self.screen, light_yellow, (int(display_width/3)+topLeftX+205,int(display_height/3)-topLeftY), (int(display_width/3)-topLeftX,int(display_height/3)+topLeftY+205), 20)            
                    win=1
    
    
            if(win == 1 or self.isFull(occ)):
                self.screen.blit(self.dim_screen, (0, 0))
                self.game_over(self.winner)
                
                
            pygame.display.update()
        
        
game = Game()
game.game_intro();